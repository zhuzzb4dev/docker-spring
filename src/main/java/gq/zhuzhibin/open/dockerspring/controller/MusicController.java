package gq.zhuzhibin.open.dockerspring.controller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import gq.zhuzhibin.open.dockerspring.component.CommonComponent;
import gq.zhuzhibin.open.dockerspring.config.MyConfig;
import gq.zhuzhibin.open.dockerspring.entity.Music;
import gq.zhuzhibin.open.dockerspring.service.UserService;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 1800L)
public class MusicController {

    @Resource
    private CommonComponent commonComponent;

    @Resource
    private UserService userService;

    @Resource
    private MyConfig myConfig;

    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping("test")
    public String index() {
        userService.add();
        return commonComponent.test();
    }

    @RequestMapping("musicList")
    public List<Music> musicList() {
//        ArrayList<String> urls = new ArrayList<>();
//        File dir = new File(myConfig.getMediaLocation());
//        if (dir.exists() && dir.isDirectory()) {
//            File[] files = dir.listFiles();
//            if (Objects.nonNull(files)) {
//                for (File file : files) {
//                    urls.add(myConfig.getMediaUrl() + file.getName());
//                }
//            }
//
//        }
        Query query=new Query(new Criteria());
        List<Music> list = mongoTemplate.find(query, Music.class);
        return list;
    }

    @RequestMapping("musicInit")
    public ArrayList<String> musicInit() throws InvalidDataException, UnsupportedTagException, IOException {
        ArrayList<String> urls = new ArrayList<>();
        File dir = new File(myConfig.getMediaLocation());
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (Objects.nonNull(files)) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".mp3")) {
                        urls.add(myConfig.getMediaUrl() + file.getName());
                        Mp3File mp3file = new Mp3File(file);
                        if (mp3file.hasId3v2Tag()) {
                            ID3v2 tag = mp3file.getId3v2Tag();
                            Music music = new Music();
                            music.setFileName(file.getName());
                            music.setTitle(tag.getTitle());
                            music.setAlbum(tag.getAlbum());
                            music.setArtist(tag.getArtist());
                            mongoTemplate.save(music);
                        }
                    }

                }
            }

        }
        return urls;
    }

}

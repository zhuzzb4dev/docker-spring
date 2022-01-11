package gq.zhuzhibin.open.dockerspring.controller;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import gq.zhuzhibin.open.dockerspring.config.MyConfig;
import gq.zhuzhibin.open.dockerspring.entity.Music;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

@Controller
public class RedirectController {

    @Resource
    private MyConfig myConfig;

    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping("musicGet/{_id}")
    public String musicGet(@PathVariable String _id) throws InvalidDataException, UnsupportedTagException, IOException {
        Query query=new Query(Criteria.where("_id").is(_id));
        Music one = mongoTemplate.findOne(query, Music.class);
        if (Objects.nonNull(one)) {
            String fileName = one.getFileName();
            return "redirect:" + myConfig.getMediaUrl() + fileName;
        }
        return "404";
    }

}

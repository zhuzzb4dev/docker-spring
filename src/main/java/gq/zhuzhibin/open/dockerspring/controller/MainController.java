package gq.zhuzhibin.open.dockerspring.controller;

import gq.zhuzhibin.open.dockerspring.component.CommonComponent;
import gq.zhuzhibin.open.dockerspring.config.MyConfig;
import gq.zhuzhibin.open.dockerspring.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 1800L)
public class MainController {

    @Resource
    private CommonComponent commonComponent;

    @Resource
    private UserService userService;

    @Resource
    private MyConfig myConfig;

    @RequestMapping("test")
    public String index() {
        userService.add();
        return commonComponent.test();
    }

    @RequestMapping("musicList")
    public ArrayList<String> musicList() {
        ArrayList<String> urls = new ArrayList<>();
        File dir = new File(myConfig.getMediaLocation());
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (Objects.nonNull(files)) {
                for (File file : files) {
                    urls.add(myConfig.getMediaUrl() + file.getName());
                }
            }

        }
        return urls;
    }
}

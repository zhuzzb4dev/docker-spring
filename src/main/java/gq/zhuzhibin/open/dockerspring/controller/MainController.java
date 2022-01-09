package gq.zhuzhibin.open.dockerspring.controller;

import gq.zhuzhibin.open.dockerspring.component.CommonComponent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 1800L)
public class MainController {

    @Resource
    private CommonComponent commonComponent;

    @RequestMapping("test")
    public String index(){
        return commonComponent.test();
    }
}

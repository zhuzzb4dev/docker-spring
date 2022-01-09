package gq.zhuzhibin.open.dockerspring.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 1800L)
public class MainController {

    @RequestMapping("test")
    public String index(){
        return "zzb";
    }
}

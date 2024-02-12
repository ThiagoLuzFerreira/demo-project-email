package com.thiago.demoprojectemail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class Controller {

    @Value("${file.test}")
    private String config;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping("/configs")
    public String getConfig(){
        return config;
    }
}

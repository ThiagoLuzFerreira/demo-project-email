package com.thiago.demoprojectemail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class Controller {

    @GetMapping
    public String status(){
        return "ok";
    }
}

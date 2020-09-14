package com.wyq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    @Value("${image.server}")
    private String imageServer;

    @GetMapping("getImageServer")
    public String getImageServer(){
        return imageServer;
    }

}

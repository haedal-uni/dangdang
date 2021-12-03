package com.sparta.dangdang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    @GetMapping("/")
    public String getPageIndex(){
        return "index";
    }

    @GetMapping("/dodo")
    public String getPageDodo(){
        return "dodo";
    }
}

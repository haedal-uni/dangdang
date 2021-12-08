package shop.dangdang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    @GetMapping("/")
    public String getPageIndex(){
        return "index";
    }

    @GetMapping("/detail")
    public String getdetail(){
        return "detail";
    }

    @GetMapping("/main")
    public String getPagemain(){
        return "mainpage";
    }

    @GetMapping("/photo")
    public String getphoto(){
        return "photopage";
    }

    @GetMapping("/writer")
    public String getPageRegistry(){
        return "registry";
    }

}

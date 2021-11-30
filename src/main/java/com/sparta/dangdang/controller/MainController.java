package com.sparta.dangdang.controller;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @GetMapping("/Main/{userId}")
    public Feed getMain(@PathVariable Long userId){
        return mainService.getMain(userId);
    }
}

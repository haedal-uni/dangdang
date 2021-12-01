package com.sparta.dangdang.controller;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.dto.FeedDto;
import com.sparta.dangdang.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @GetMapping("/Main")
    public List<Feed> getMain(@RequestBody FeedDto feedDto, @PathVariable User nickName) {
        return mainService.getMain(feedDto, nickName);
    }

}

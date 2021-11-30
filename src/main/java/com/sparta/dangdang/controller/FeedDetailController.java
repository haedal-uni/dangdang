package com.sparta.dangdang.controller;

import com.sparta.dangdang.dto.feedDetailResponseDto;
import com.sparta.dangdang.service.FeedDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeedDetailController {
    private final FeedDetailService feedDetailService;

    public FeedDetailController(FeedDetailService feedDetailService) {
        this.feedDetailService = feedDetailService;
    }

    @GetMapping("/api/feed/{feedIdx}")
    public feedDetailResponseDto getArticles(@PathVariable Long feedIdx){
        String loginUserId = "manijang2";
        return feedDetailService.getFeedDetail(feedIdx, loginUserId);
    }
}

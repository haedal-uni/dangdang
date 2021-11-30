package com.sparta.dangdang.controller;

import com.sparta.dangdang.dto.PostDetailResponseDto;
import com.sparta.dangdang.service.PostDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostDetailController {
    private final PostDetailService postDetailService;

    public PostDetailController(PostDetailService postDetailService) {
        this.postDetailService = postDetailService;
    }

    @GetMapping("/api/post/{postIdx}")
    public PostDetailResponseDto getArticles(@PathVariable Long postIdx){
        String loginUserId = "manijang2";
        return postDetailService.getPostDetail(postIdx, loginUserId);
    }
}

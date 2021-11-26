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

    @GetMapping("/api/post/{id}")
    public PostDetailResponseDto getArticles(@PathVariable Long id){
        return postDetailService.getPostDetail(id);
    }
}

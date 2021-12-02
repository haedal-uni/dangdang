package com.sparta.dangdang.controller;

import com.sparta.dangdang.dto.*;
import com.sparta.dangdang.service.FeedDetailService;
import org.springframework.web.bind.annotation.*;


@RestController
public class FeedDetailController {
    private final FeedDetailService feedDetailService;

    public FeedDetailController(FeedDetailService feedDetailService) {
        this.feedDetailService = feedDetailService;
    }

    @GetMapping("/api/feed/{feedIdx}")
    public FeedDetailResponseDto getFeedDetail(@PathVariable Long feedIdx){
        return feedDetailService.getFeedDetail(feedIdx, "manijang2");
    }


    @PutMapping("/api/feed/{feedIdx}/like")
    public FeedLikeResponseDto setFeedLike(@PathVariable Long feedIdx, @RequestBody FeedLikeRequestDto feedLikeRequestDto){
        return feedDetailService.setFeedLike(feedIdx, "manijang2", feedLikeRequestDto.getLike());
    }

    @GetMapping("/api/feed/{feedIdx}/comment")
    public CommentResponseDto getFeedComment(@PathVariable Long feedIdx){
        return feedDetailService.getFeedComment(feedIdx);
    }

    @PutMapping("/api/feed/{feedIdx}/comment")
    public CommonMsgResponseDto setFeedComment(@PathVariable Long feedIdx, @RequestParam("comment")String comment){
        return feedDetailService.setFeedComment(feedIdx, "manijang2", comment);
    }

    @DeleteMapping("/api/feed/comment/{commentIdx}")
    public CommonMsgResponseDto deleteFeedComment(@PathVariable Long commentIdx){
        return feedDetailService.deleteFeedComment(commentIdx);
    }
}
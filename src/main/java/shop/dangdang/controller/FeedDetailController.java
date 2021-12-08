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

    // 상세보기클릭시 게시글 정보를 가져옵니다.
    @GetMapping("/api/feed/{feedIdx}")
    public FeedDetailResponseDto getFeedDetail(@PathVariable Long feedIdx){
        return feedDetailService.getFeedDetail(feedIdx, "manijang2");
    }

    // 좋아요 기능 입니다. (서로 반대 상태로 전환합니다.)
    @PutMapping("/api/feed/{feedIdx}/like")
    public FeedLikeResponseDto setFeedLike(@PathVariable Long feedIdx, @RequestBody FeedLikeRequestDto feedLikeRequestDto){
        return feedDetailService.setFeedLike(feedIdx, "manijang2", feedLikeRequestDto.getLike());
    }

    // 댓글을 가져옵니다.
    @GetMapping("/api/feed/{feedIdx}/comment")
    public CommentResponseDto getFeedComment(@PathVariable Long feedIdx){
        return feedDetailService.getFeedComment(feedIdx);
    }

    // 댓글을 생성합니다.
    @PutMapping("/api/feed/{feedIdx}/comment")
    public CommonMsgResponseDto setFeedComment(@PathVariable Long feedIdx, @RequestParam("comment")String comment){
        return feedDetailService.setFeedComment(feedIdx, "manijang2", comment);
    }

    // 댓글을 삭제합니다.
    @DeleteMapping("/api/feed/comment/{commentIdx}")
    public CommonMsgResponseDto deleteFeedComment(@PathVariable Long commentIdx){
        return feedDetailService.deleteFeedComment(commentIdx);
    }
}
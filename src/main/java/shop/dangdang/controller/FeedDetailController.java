package shop.dangdang.controller;

import org.springframework.web.bind.annotation.*;
import shop.dangdang.service.FeedDetailService;


@RestController
public class FeedDetailController {
    private final FeedDetailService feedDetailService;

    public FeedDetailController(FeedDetailService feedDetailService) {
        this.feedDetailService = feedDetailService;
    }

    // 상세보기클릭시 게시글 정보를 가져옵니다.
    @GetMapping("/api/feed/{feedIdx}")
    public shop.dangdang.dto.FeedDetailResponseDto getFeedDetail(@PathVariable Long feedIdx){
        return feedDetailService.getFeedDetail(feedIdx, "manijang2");
    }

    // 좋아요 기능 입니다. (서로 반대 상태로 전환합니다.)
    @PutMapping("/api/feed/{feedIdx}/like")
    public shop.dangdang.dto.FeedLikeResponseDto setFeedLike(@PathVariable Long feedIdx, @RequestBody shop.dangdang.dto.FeedLikeRequestDto feedLikeRequestDto){
        return feedDetailService.setFeedLike(feedIdx, "manijang2", feedLikeRequestDto.getLike());
    }

    // 댓글을 가져옵니다.
    @GetMapping("/api/feed/{feedIdx}/comment")
    public shop.dangdang.dto.CommentResponseDto getFeedComment(@PathVariable Long feedIdx){
        return feedDetailService.getFeedComment(feedIdx);
    }

    // 댓글을 생성합니다.
    @PutMapping("/api/feed/{feedIdx}/comment")
    public shop.dangdang.dto.CommonMsgResponseDto setFeedComment(@PathVariable Long feedIdx, @RequestParam("comment")String comment){
        return feedDetailService.setFeedComment(feedIdx, "manijang2", comment);
    }

    // 댓글을 삭제합니다.
    @DeleteMapping("/api/feed/comment/{commentIdx}")
    public shop.dangdang.dto.CommonMsgResponseDto deleteFeedComment(@PathVariable Long commentIdx){
        return feedDetailService.deleteFeedComment(commentIdx);
    }
}
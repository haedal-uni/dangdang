package shop.dangdang.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import shop.dangdang.dto.*;
import shop.dangdang.service.FeedDetailService;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.util.SecurityUtil;


@RestController
public class FeedDetailController {
    private final FeedDetailService feedDetailService;

    public FeedDetailController(FeedDetailService feedDetailService) {
        this.feedDetailService = feedDetailService;
    }

    // 상세보기클릭시 게시글 정보를 가져옵니다.
    @GetMapping("/feed/{feedIdx}")
    public FeedDetailResponseDto getFeedDetail(@PathVariable Long feedIdx){
        System.out.println();
        SecurityUtil.getCurrentUsername().ifPresent(nickName -> {
            System.out.println(nickName);
        });

        if(SecurityUtil.getCurrentUsername().isPresent()) {
            System.out.println("값이 있음 :: " + SecurityUtil.getCurrentUsername().get());
        } else {
            System.out.println("값이 없음");
        }

        return feedDetailService.getFeedDetail(feedIdx, "manijang2");
    }

    // 좋아요 기능 입니다. (서로 반대 상태로 전환합니다.)
    @PutMapping("/feed/{feedIdx}/like")
    public FeedLikeResponseDto setFeedLike(@PathVariable Long feedIdx, @RequestBody FeedLikeRequestDto feedLikeRequestDto){
        return feedDetailService.setFeedLike(feedIdx, "manijang2", feedLikeRequestDto.getLike());
    }

    // 댓글을 가져옵니다.
    @GetMapping("/feed/{feedIdx}/comment")
    public CommentResponseDto getFeedComment(@PathVariable Long feedIdx){
        return feedDetailService.getFeedComment(feedIdx);
    }

    // 댓글을 생성합니다.
    @PutMapping("/feed/{feedIdx}/comment")
    public CommonMsgResponseDto setFeedComment(@PathVariable Long feedIdx, @RequestParam("comment")String comment){
        return feedDetailService.setFeedComment(feedIdx, "manijang2", comment);
    }

    // 댓글을 삭제합니다.
    @DeleteMapping("/feed/comment/{commentIdx}")
    public CommonMsgResponseDto deleteFeedComment(@PathVariable Long commentIdx){
        return feedDetailService.deleteFeedComment(commentIdx);
    }
}
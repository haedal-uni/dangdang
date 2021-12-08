package shop.dangdang.service;

import shop.dangdang.domain.Comment;
import shop.dangdang.domain.Feed;
import shop.dangdang.domain.FeedLikeUser;
import shop.dangdang.domain.Membership;
import shop.dangdang.dto.CommentResponseDto;
import shop.dangdang.dto.CommonMsgResponseDto;
import shop.dangdang.dto.FeedDetailResponseDto;
import shop.dangdang.dto.FeedLikeResponseDto;
import shop.dangdang.repository.*;
import org.springframework.stereotype.Service;

@Service
public class FeedDetailService {
    private final FeedRepository feedRepository;
    private final MembershipRepository membershipRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;
    private final CommentRepository commentRepository;

    public FeedDetailService(FeedRepository feedRepository, MembershipRepository membershipRepository, FeedLikeUserRepository feedLikeUserRepository, CommentRepository commentRepository) {
        this.feedRepository = feedRepository;
        this.membershipRepository = membershipRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
        this.commentRepository = commentRepository;
    }

    // 상세보기클릭시 게시글 정보를 가져옵니다.
    // 로그인 구현시 userNickName 값 가져온다.
    public FeedDetailResponseDto getFeedDetail(Long feedIdx, String userNickName) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Long writerIdx = feed.getMembership().getIdx();
        boolean like = false;
        FeedLikeUser feedLikeUsers = feedLikeUserRepository.findByUserIdx(writerIdx);
        if(feedLikeUsers != null) {
            like = true;
        }

        return new FeedDetailResponseDto(
                feed.getIdx(),
                feed.getMainImagePath(),
                like,
                feed.getLikeCount(),
                feed.getMembership().getNickName(),
                feed.getCreatedDate().toString(),
                feed.getMembership().getProfileImgUrl(),
                feed.getAddress(),
                feed.getContent()
        );
    }

    // 좋아요 기능 입니다. (서로 반대 상태로 전환합니다.)
    public FeedLikeResponseDto setFeedLike(Long feedIdx, String userNickName, Boolean requestLike) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Membership loginUser = membershipRepository.findByNickName(userNickName).orElseThrow(
                () -> new NullPointerException("해당 사용자가 없습니다.")
        );

        boolean currentLike = false;

        FeedLikeUser feedLikeUser = feedLikeUserRepository.findByUserIdx(loginUser.getIdx());
        if(feedLikeUser != null) {
            currentLike = true;
        }

        if(!currentLike && requestLike) {
            feedLikeUser = new FeedLikeUser(feed, loginUser);
            feedLikeUserRepository.save(feedLikeUser);
        } else if(currentLike && !requestLike) {
            feed.setLike(false);
            feedLikeUserRepository.delete(feedLikeUser);
        }

        return new FeedLikeResponseDto(feedIdx, requestLike); // ?? dto에 담아서 return?
    }

    // 댓글을 가져옵니다.
    public CommentResponseDto getFeedComment(long feedIdx) {
        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        return new CommentResponseDto(feedIdx, feed.getComments());
    }

    // 댓글을 생성합니다.
    public CommonMsgResponseDto setFeedComment(Long feedIdx, String userNickName, String commentConent) {
        Membership loginUser = membershipRepository.findByNickName(userNickName).orElseThrow(
                () -> new NullPointerException("해당 사용자가 없습니다.")
        );

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Comment comment = new Comment(loginUser, commentConent, feed);
        commentRepository.save(comment);

        return new CommonMsgResponseDto(200L, "댓글 등록이 성공하였습니다", null);
    }

    // 댓글을 삭제합니다.
    public CommonMsgResponseDto deleteFeedComment(Long commentIdx) {
        Comment comment = commentRepository.findById(commentIdx).orElseThrow(
                () -> new NullPointerException("해당 코멘트가 없습니다.")
        );

        commentRepository.delete(comment);

        return new CommonMsgResponseDto(200L, "댓글를 삭제하는데 성공하였습니다", null);
    }
}

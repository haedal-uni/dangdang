package shop.dangdang.service;

import shop.dangdang.domain.Comment;
import shop.dangdang.domain.Feed;
import shop.dangdang.domain.FeedLikeUser;
import shop.dangdang.domain.User;
import shop.dangdang.dto.CommentResponseDto;
import shop.dangdang.dto.CommonMsgResponseDto;
import shop.dangdang.dto.FeedDetailResponseDto;
import shop.dangdang.dto.FeedLikeResponseDto;
import shop.dangdang.repository.CommentRepository;
import shop.dangdang.repository.FeedLikeUserRepository;
import shop.dangdang.repository.FeedRepository;
import shop.dangdang.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedDetailService {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;
    private final CommentRepository commentRepository;

    public FeedDetailService(FeedRepository feedRepository, UserRepository userRepository, FeedLikeUserRepository feedLikeUserRepository, CommentRepository commentRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
        this.commentRepository = commentRepository;
    }

    public FeedDetailResponseDto getFeedDetail(Long feedIdx, String userNickName) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Long writerIdx = feed.getWriter().getIdx();
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
                feed.getWriter().getNickName(),
                feed.getCreatedDate().toString(),
                feed.getWriter().getProfileImgName(),
                feed.getAddress(),
                feed.getContent()
        );
    }

    public FeedLikeResponseDto setFeedLike(Long feedIdx, String userNickName, Boolean requestLike) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        User loginUser = userRepository.findByNickName(userNickName).orElseThrow(
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

        return new FeedLikeResponseDto(feedIdx, requestLike);
    }

    public CommentResponseDto getFeedComment(long feedIdx) {
        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        return new CommentResponseDto(feedIdx, feed.getComments());
    }

    public CommonMsgResponseDto setFeedComment(Long feedIdx, String userNickName, String commentConent) {
        User loginUser = userRepository.findByNickName(userNickName).orElseThrow(
                () -> new NullPointerException("해당 사용자가 없습니다.")
        );

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Comment comment = new Comment(loginUser, commentConent, feed);
        commentRepository.save(comment);

        return new CommonMsgResponseDto(200L, "댓글 등록이 성공하였습니다", null);
    }

    public CommonMsgResponseDto deleteFeedComment(Long commentIdx) {
        Comment comment = commentRepository.findById(commentIdx).orElseThrow(
                () -> new NullPointerException("해당 코멘트가 없습니다.")
        );

        commentRepository.delete(comment);

        return new CommonMsgResponseDto(200L, "댓글를 삭제하는데 성공하였습니다", null);
    }
}

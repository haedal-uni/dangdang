package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.domain.FeedLikeUser;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.dto.CommentResponseDto;
import com.sparta.dangdang.dto.FeedDetailResponseDto;
import com.sparta.dangdang.dto.FeedLikeResponseDto;
import com.sparta.dangdang.repository.FeedLikeUserRepository;
import com.sparta.dangdang.repository.FeedRepository;
import com.sparta.dangdang.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedDetailService {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;

    public FeedDetailService(FeedRepository feedRepository, UserRepository userRepository, FeedLikeUserRepository feedLikeUserRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
    }

    public FeedDetailResponseDto getFeedDetail(Long feedIdx, String loginUserId) {

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

    public FeedLikeResponseDto setFeedLike(Long feedIdx, String loginUserId, Boolean requestLike) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        User loginUser = userRepository.findByUserId(loginUserId).orElseThrow(
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
}

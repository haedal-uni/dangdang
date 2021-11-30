package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.domain.FeedLikeUser;
import com.sparta.dangdang.dto.feedDetailResponseDto;
import com.sparta.dangdang.repository.FeedLikeUserRepository;
import com.sparta.dangdang.repository.FeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedDetailService {
    private final FeedRepository feedRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;

    public FeedDetailService(FeedRepository feedRepository, FeedLikeUserRepository feedLikeUserRepository) {
        this.feedRepository = feedRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
    }

    public feedDetailResponseDto getFeedDetail(Long feedIdx, String loginUserId) {

        Feed feed = feedRepository.findById(feedIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Long loginUserIdx = feed.getWriter().getIdx();

        List<FeedLikeUser> feedLikeUsers = feedLikeUserRepository.findByUserIdx(loginUserIdx);
        System.out.println(feedLikeUsers);
        Boolean like = false;

        return new feedDetailResponseDto(
                feed.getIdx(),
                feed.getMainImagePath(),
                like,
                feed.getLikeCount(),
                feed.getWriter().getUserId(),
                feed.getUpdateDate(),
                feed.getWriter().getUserProfileImg(),
                feed.getAddress(),
                feed.getContent()
        );
    }
}

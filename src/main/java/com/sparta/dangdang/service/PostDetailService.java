package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.dto.PostDetailResponseDto;
import com.sparta.dangdang.repository.PostLikeUserRepository;
import com.sparta.dangdang.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostDetailService {
    private final PostRepository postRepository;
    private final PostLikeUserRepository postLikeUserRepository;

    public PostDetailService(PostRepository postRepository, PostLikeUserRepository postLikeUserRepository) {
        this.postRepository = postRepository;
        this.postLikeUserRepository = postLikeUserRepository;
    }

    public PostDetailResponseDto getPostDetail(Long postIdx, String loginUserId) {

        Post post = postRepository.findById(postIdx).orElseThrow(
                () -> new NullPointerException("해당 포스트가 없습니다.")
        );

        Long loginUserIdx = post.getWriter().getIdx();

        Boolean like = false;

        return new PostDetailResponseDto(
                post.getIdx(),
                post.getMainImagePath(),
                like,
                post.getLikeCount(),
                post.getWriter().getUserId(),
                post.getUpdateDate(),
                post.getWriter().getUserProfileImg(),
                post.getAddress(),
                post.getContent()
        );
    }
}

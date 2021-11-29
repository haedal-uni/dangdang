package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.dto.PostDetailResponseDto;
import com.sparta.dangdang.repository.PostRepository;
import com.sparta.dangdang.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostDetailService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDetailService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostDetailResponseDto getPostDetail(Long post_idx, String login_id) {

        Post post = postRepository.findById(post_idx).orElseThrow(
                () -> new NullPointerException("해당 포스트가 없습니다.")
        );

        Boolean like = false;

        return new PostDetailResponseDto(
                post.getId(),
                post.getMain_image_path(),
                like,
                post.getLike_count(),
                post.getWriter().getUser_id(),
                post.getUpdate_date(),
                post.getWriter().getUser_profile_img(),
                post.getAddress(),
                post.getContent()
        );
    }
}

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

    public PostDetailResponseDto getPostDetail(Long post_idx) {

        Post post = postRepository.findById(post_idx).orElseThrow(
                () -> new NullPointerException("해당 포스트가 없습니다.")
        );

        String content = "테스트 내용 01";

        Boolean like = false;
        Long like_count = 0L;
        String address = "서울시 마포구 아현동 아이아이파크";

        return new PostDetailResponseDto(
                post.getId(),
                post.getMain_image_path(),
                like,
                like_count,
                post.getWriter().getUser_id(),
                post.getUpdate_date(),
                post.getWriter().getUser_profile_img(),
                address,
                content
        );
    }
}

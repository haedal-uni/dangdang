package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.dto.PostDetailResponseDto;
import com.sparta.dangdang.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class PostDetailService {
    private final PostRepository postRepository;

    public PostDetailService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDetailResponseDto getPostDetail(Long post_idx) {

        Post post = postRepository.findById(post_idx).orElseThrow(
                () -> new NullPointerException("해당 포스트가 없습니다.")
        );

        String content = "테스트 내용 01";

        Boolean like = false;
        Long like_count = 0L;
        String user_profile_image_path = "test.png";
        String address = "서울시 마포구 아현동 아이아이파크";

        return new PostDetailResponseDto(
                post_idx,
                post.getMain_image_path(),
                like,
                like_count,
                post.getUser_id(),
                post.getUpdate_date(),
                user_profile_image_path,
                address,
                content
        );
    }
}

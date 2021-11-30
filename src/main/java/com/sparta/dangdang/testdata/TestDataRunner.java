package com.sparta.dangdang.testdata;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.domain.PostLikeUser;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.repository.PostLikeUserRepository;
import com.sparta.dangdang.repository.PostRepository;
import com.sparta.dangdang.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Component
public class TestDataRunner implements ApplicationRunner {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikeUserRepository postLikeUserRepository;

    public TestDataRunner(PostRepository postRepository, UserRepository userRepository, PostLikeUserRepository postLikeUserRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postLikeUserRepository = postLikeUserRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("manijang2");
        userRepository.save(user);

        String update_date = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분").format(System.currentTimeMillis());
        String main_image_path = "test.png";
        String content = "내용_01";
        String address = "서울시 마포구 아현아이파크";

        Post post = new Post(user, update_date, main_image_path, content, address);
        postRepository.save(post);

        post.addLikeUser(user);

        PostLikeUser postLikeUser = new PostLikeUser(post, user);
        postLikeUserRepository.save(postLikeUser);
    }
}

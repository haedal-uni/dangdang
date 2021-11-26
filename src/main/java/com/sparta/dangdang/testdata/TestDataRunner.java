package com.sparta.dangdang.testdata;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.repository.PostRepository;
import com.sparta.dangdang.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TestDataRunner implements ApplicationRunner {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public TestDataRunner(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User("manijang2");
        userRepository.save(user);

        for (int i = 0; i < 100; i++) {

            String update_date = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분").format(System.currentTimeMillis());
            String main_image_path = "test.png";
            String content = "내용_" + i;

            postRepository.save(new Post(user, update_date, main_image_path, content));
        }
    }
}

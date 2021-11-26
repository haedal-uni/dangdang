package com.sparta.dangdang.testdata;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

// @Component
public class TestDataRunner implements ApplicationRunner {
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 100; i++) {
            String user_id = "사용자_" + i;
            String update_date = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분").format(System.currentTimeMillis());
            String main_image_path = "test.png";
            String content = "내용_" + i;
            postRepository.save(new Post(user_id, update_date, main_image_path, content));
        }
    }
}

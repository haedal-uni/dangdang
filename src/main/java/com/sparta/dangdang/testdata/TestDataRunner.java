package com.sparta.dangdang.testdata;

import com.sparta.dangdang.domain.Feed;
import com.sparta.dangdang.domain.FeedLikeUser;
import com.sparta.dangdang.domain.User;
import com.sparta.dangdang.repository.FeedLikeUserRepository;
import com.sparta.dangdang.repository.FeedRepository;
import com.sparta.dangdang.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

// @Component
public class TestDataRunner implements ApplicationRunner {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;

    public TestDataRunner(FeedRepository feedRepository, UserRepository userRepository, FeedLikeUserRepository feedLikeUserRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("manijang2");
        userRepository.save(user);

        String main_image_path = "test.png";
        String content = "내용_01";
        String address = "서울시 마포구 아현아이파크";

        Feed feed = new Feed(user, main_image_path, content, address);
        feedRepository.save(feed);

        feed.addLikeUser(user);

        FeedLikeUser feedLikeUser = new FeedLikeUser(feed, user);
        feedLikeUserRepository.save(feedLikeUser);
    }
}

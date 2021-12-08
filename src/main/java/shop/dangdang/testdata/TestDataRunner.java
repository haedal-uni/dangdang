package shop.dangdang.testdata;

import shop.dangdang.domain.Comment;
import shop.dangdang.domain.Feed;
import shop.dangdang.domain.FeedLikeUser;
import shop.dangdang.domain.User;
import shop.dangdang.repository.CommentRepository;
import shop.dangdang.repository.FeedLikeUserRepository;
import shop.dangdang.repository.FeedRepository;
import shop.dangdang.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// @Component
public class TestDataRunner implements ApplicationRunner {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;
    private final CommentRepository commentRepository;

    public TestDataRunner(FeedRepository feedRepository, UserRepository userRepository, FeedLikeUserRepository feedLikeUserRepository, CommentRepository commentRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("manijang2", "thumb.jpeg");
        userRepository.save(user);

        String main_image_path = "img03.jpg";
        String content = "내용_01";
        String address = "서울시 마포구 아현아이파크";

        Feed feed = new Feed(user, main_image_path, content, address);
        feedRepository.save(feed);

        FeedLikeUser feedLikeUser = new FeedLikeUser(feed, user);
        feedLikeUserRepository.save(feedLikeUser);

        Comment comment1 = new Comment(user, "코멘트 내용 01", feed);
        commentRepository.save(comment1);
        Comment comment2 = new Comment(user, "코멘트 내용 02", feed);
        commentRepository.save(comment2);
    }
}
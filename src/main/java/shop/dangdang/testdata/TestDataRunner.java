package shop.dangdang.testdata;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import shop.dangdang.domain.*;
import shop.dangdang.repository.CommentRepository;
import shop.dangdang.repository.FeedLikeUserRepository;
import shop.dangdang.repository.FeedRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import shop.dangdang.repository.MembershipRepository;

import java.util.Collections;

@Component
public class TestDataRunner implements ApplicationRunner {
    private final FeedRepository feedRepository;
    private final MembershipRepository membershipRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;
    private final CommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    public TestDataRunner(FeedRepository feedRepository, MembershipRepository membershipRepository, FeedLikeUserRepository feedLikeUserRepository, CommentRepository commentRepository, PasswordEncoder passwordEncoder) {
        this.feedRepository = feedRepository;
        this.membershipRepository = membershipRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
        this.commentRepository = commentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Membership user = new Membership("manijang2", passwordEncoder.encode("1234"), "manijang2@naver.com", true, Collections.singleton(authority));
        membershipRepository.save(user);
//
//        String main_image_path = "img03.jpg";
//        String content = "내용_01";
//        String address = "서울시 마포구 아현아이파크";
//
//        Feed feed = new Feed(user, main_image_path, content, address);
//        feedRepository.save(feed);
//
//        FeedLikeUser feedLikeUser = new FeedLikeUser(feed, user);
//        feedLikeUserRepository.save(feedLikeUser);
//
//        Comment comment1 = new Comment(user, "코멘트 내용 01", feed);
//        commentRepository.save(comment1);
//        Comment comment2 = new Comment(user, "코멘트 내용 02", feed);
//        commentRepository.save(comment2);
    }
}
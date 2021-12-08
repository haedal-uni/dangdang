package shop.dangdang.testdata;

import shop.dangdang.domain.*;
import shop.dangdang.repository.CommentRepository;
import shop.dangdang.repository.FeedLikeUserRepository;
import shop.dangdang.repository.FeedRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import shop.dangdang.repository.MembershipRepository;

// @Component
public class TestDataRunner implements ApplicationRunner {
    private final FeedRepository feedRepository;
    private final MembershipRepository membershipRepository;
    private final FeedLikeUserRepository feedLikeUserRepository;
    private final CommentRepository commentRepository;

    public TestDataRunner(FeedRepository feedRepository, MembershipRepository membershipRepository, FeedLikeUserRepository feedLikeUserRepository, CommentRepository commentRepository) {
        this.feedRepository = feedRepository;
        this.membershipRepository = membershipRepository;
        this.feedLikeUserRepository = feedLikeUserRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Membership membership = new Membership("thumb.jpeg", "manijang2", "123456", "dangdang@gmail.com", "thumb.jpeg");
        membershipRepository.save(membership);

        String main_image_path = "img03.jpg";
        String content = "내용_01";
        String address = "서울시 마포구 아현아이파크";

        Feed feed = new Feed(membership, main_image_path, content, address);
        feedRepository.save(feed);

        FeedLikeUser feedLikeUser = new FeedLikeUser(feed, membership);
        feedLikeUserRepository.save(feedLikeUser);

        Comment comment1 = new Comment(membership, "코멘트 내용 01", feed);
        commentRepository.save(comment1);
        Comment comment2 = new Comment(membership, "코멘트 내용 02", feed);
        commentRepository.save(comment2);
    }
}
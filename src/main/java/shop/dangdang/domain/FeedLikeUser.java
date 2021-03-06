package shop.dangdang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class FeedLikeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "feedIdx")
    private Feed feed;                  // 좋아요한 포스트

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private Membership user;                  // 좋아요 누른 사용자

    public FeedLikeUser(Feed feed, Membership user) {
        this.feed = feed;
        this.user = user;

        feed.getLikeUsers().add(this);
        user.getLikeFeeds().add(this);

        feed.setLike(true);
    }
}

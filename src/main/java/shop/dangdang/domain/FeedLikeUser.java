package shop.dangdang.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedLikeUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="FeedLikeUserId")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "MembershipId")
    private Membership membership;           // 글 작성자

    @ManyToOne
    @JoinColumn(name = "FeedId")
    private Feed feed;                       // 좋아요한 포스트

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

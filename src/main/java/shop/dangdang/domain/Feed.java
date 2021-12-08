package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Feed {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="FeedId")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "MembershipId")
    private Membership membership;      // 글 작성자

    @ManyToOne
    @JoinColumn(name = "RegistryId")
    private Registry registry;          // 글 작성자

    @CreatedDate
    private LocalDateTime createdDate;  // 글 생성일자

    @Column(nullable = true)
    private String mainImagePath;       // 글 메인 이미지 파일명(ex-filename.png)

    @Column(nullable = false)
    private String content;             // 글 내용

    @Column(nullable = false)
    private String address;             // 글 or 사진을 올린 장소

    @Column(nullable = false)
    private Long likeCount;             // 글 좋아요 개수

    @OneToMany(mappedBy = "feed")
    private List<FeedLikeUser> likeUsers;  // 좋아요 누른 사용자들 리스트에 넣기

    @OneToMany(mappedBy = "feed")
    @JsonBackReference
    private List<Comment> comments;


    public Feed(Membership membership, String mainImagePath, String content, String address) {
        setWriter(membership);
        this.mainImagePath = mainImagePath;
        this.content = content;
        this.address = address;
        this.likeCount = 0L;
    }

    public void setWriter(Membership membership) {
        this.membership = membership;

        if(!membership.getFeeds().contains(this)) {
            membership.getFeeds().add(this);
        }
    }

    public void setLike(Boolean isLike) {
        if(isLike) {
            likeCount += 1;
        } else {
            likeCount -= 1;
        }
    }
}

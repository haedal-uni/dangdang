package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Membership {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="MembershipId")
    private Long idx;

    @Column(nullable = true)
    private String profileImgUrl;   // 사용자 프로필 이미지 Url

    @Column(nullable = true)
    private String nickName;        // 사용자 아이디

    @JsonIgnore                     // 조회했을 때 json에 뜨지 않는다
    @Column(nullable = false)
    private String password;        // 사용자 비밀번호

    @JsonIgnore                     // 조회했을 때 json에 뜨지 않는다
    @Column(nullable = false)
    private String email;           // 사용자 이메일

    @Column(nullable = false)
    private String puppy;           // 강아지 종류

    @OneToMany(mappedBy = "membership")
    @JsonBackReference
    private List<Comment> comments;   // 댓글 리스트로 정리

    @OneToMany(mappedBy = "membership")
    @JsonBackReference
    private List<Feed> feeds;          // 내가 작성한 포스트들

    @OneToMany(mappedBy = "membership")
    private List<FeedLikeUser> LikeFeeds;    // 내가 좋아요 누른 포스트들

    public Membership(String profileImgUrl, String nickName, String password, String email, String puppy) {
        this.profileImgUrl = profileImgUrl;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.puppy = "default.png";
    }
}

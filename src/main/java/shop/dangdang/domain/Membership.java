package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Membership {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String nickName;         // 사용자 아이디
    @Column(nullable = true)
    private String profileImgName;  // 사용자 프로필 이미지 이름

    @OneToMany(mappedBy = "writer")
    @JsonBackReference
    private final List<Feed> writtenFeeds = new ArrayList<>();          // 내가 작성한 포스트

    @OneToMany(mappedBy = "user")
    private final List<shop.dangdang.domain.FeedLikeUser> likeFeeds = new ArrayList<>();     // 내가 좋아요를 누른 포스트

    public Membership(String nickName) {
        this.nickName = nickName;
        this.profileImgName = "default.png";
    }

    public Membership(String nickName, String userProfileImg) {
        this.nickName = nickName;
        this.profileImgName = userProfileImg;
    }

    @Column(nullable = true)
    private String puppy;
}
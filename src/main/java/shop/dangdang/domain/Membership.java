package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Membership {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    @Column(nullable = false, unique = true)
    private String nickName;        // 사용자 아이디

    @JsonIgnore
    @Column(nullable = false)
    private String password;        // 사용자 아이디

    @Column(nullable = false)
    private String email;           // 사용자 이메일

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @OneToMany(mappedBy = "writer")
    @JsonBackReference
    private final List<Feed> writtenFeeds = new ArrayList<>();          // 내가 작성한 포스트

    @OneToMany(mappedBy = "user")
    private final List<shop.dangdang.domain.FeedLikeUser> likeFeeds = new ArrayList<>();     // 내가 좋아요를 누른 포스트

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "idx")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    public Membership(String nickName, String password, String email, boolean activated, Set<Authority> authorities) {
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.activated = activated;
        this.authorities = authorities;
    }
}
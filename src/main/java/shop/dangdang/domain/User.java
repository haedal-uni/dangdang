package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import shop.dangdang.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String NickName;        // 사용자 아이디

    @OneToMany(mappedBy = "NickName")
    @JsonBackReference
    private final List<Feed> NickNameFeeds = new ArrayList<>();

    @Column(nullable = false)
    private String ProfileImg;      // 프로필 사진

    public User(UserRequestDto userDto){
        this.NickName = userDto.getNickName();
        this.ProfileImg = userDto.getProfileImg();
    }

}
package com.sparta.dangdang.domain;


import com.sparta.dangdang.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "userId")
    private Long idx;

    @Column(nullable = false)
    private String NickName;          // 사용자 아이디

    @Column(nullable = false)
    private String ProfileImg;      // 프로필 사진

    public User(UserDto userDto){
        this.NickName = userDto.getNickName();
        this.ProfileImg = userDto.getProfileImg();
    }
}
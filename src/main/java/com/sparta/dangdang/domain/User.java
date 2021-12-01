package com.sparta.dangdang.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = true)
    private String nickName;          // 사용자 아이디
    @Column(nullable = true)
    private String profileImgName;  // 사용자 프로필 이미지 이름

    @OneToMany(mappedBy = "writer")
    @JsonBackReference
    private final List<Feed> writtenFeeds = new ArrayList<>();          // 내가 작성한 포스트

    @OneToMany(mappedBy = "user")
    private final List<FeedLikeUser> likeFeeds = new ArrayList<>();     // 내가 좋아요를 누른 포스트

    public User(String userId, String userProfileImg) {
        this.nickName = userId;
        this.profileImgName = userProfileImg;
    }
}
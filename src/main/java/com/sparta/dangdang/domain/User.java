package com.sparta.dangdang.domain;


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
    private String userId;          // 사용자 아이디
    @Column(nullable = true)
    private String userProfileImg;  // 사용자 프로필 아이디

    @OneToMany(mappedBy = "writer")
    private final List<Feed> writtenFeeds = new ArrayList<>();          // 내가 작성한 포스트

    @OneToMany(mappedBy = "user")
    private final List<FeedLikeUser> likeFeeds = new ArrayList<>();     // 내가 좋아요를 누른 포스트

    public User(String userId) {
        this.userId = userId;
    }
}
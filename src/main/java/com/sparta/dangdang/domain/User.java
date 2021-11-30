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
    private String userId;
    @Column(nullable = true)
    private String userProfileImg;

    @OneToMany(mappedBy = "writer")
    private final List<Post> writtenPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<PostLikeUser> likePosts = new ArrayList<>();

    public User(String userId) {
        this.userId = userId;
    }
}
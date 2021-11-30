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
    private Long id;

    @Column(nullable = true)
    private String user_id;
    @Column(nullable = true)
    private String user_profile_img;

    @OneToMany(mappedBy = "writer")
    private final List<Post> written_posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<PostLikeUser> likePosts = new ArrayList<>();

    public User(String user_id) {
        this.user_id = user_id;
    }
}
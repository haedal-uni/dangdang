package com.sparta.dangdang.domain;


import lombok.AllArgsConstructor;
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
    private List<Post> written_posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user__like_post")
    private List<Post> like_posts = new ArrayList<>();

    public User(String user_id) {
        this.user_id = user_id;
    }

    public void addWritePost(Post post) {
        this.written_posts.add(post);
        if(post.getWriter() != this) {
            post.setWriter(this);
        }
    }

    public void addLikePost(Post post) {
        this.like_posts.add(post);
    }
}
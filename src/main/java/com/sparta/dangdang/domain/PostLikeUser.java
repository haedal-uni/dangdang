package com.sparta.dangdang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class PostLikeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "UEER_ID")
    private User user;

    public PostLikeUser(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}

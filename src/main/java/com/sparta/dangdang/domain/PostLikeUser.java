package com.sparta.dangdang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class PostLikeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "post_idx")
    private Post post;                  // 좋아요한 포스트

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;                  // 좋아요 누른 사용자

    public PostLikeUser(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}

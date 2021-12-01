package com.sparta.dangdang.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "commentUser")
    User commentUser;       // 댓글 사용자

    @ManyToOne
    @JoinColumn(name = "feed")
    Feed feed;       // 댓글 사용자


    @Column(nullable = false)
    String content;         // 댓글 내용

    @CreatedDate
    LocalDateTime createDate;

    public Comment(User commentUser, String content) {
        this.commentUser = commentUser;
        this.content = content;
    }
}
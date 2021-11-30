package com.sparta.dangdang.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "idx")
    private User writer;
    @Column(nullable = true)
    private String updateDate;
    @Column(nullable = true)
    private String mainImagePath;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Long likeCount;

    @OneToMany(mappedBy = "post")
    private final List<PostLikeUser> likeUsers = new ArrayList<>();

    public Post(User writer, String updateDate, String mainImagePath, String content, String address) {
        setWriter(writer);
        this.updateDate = updateDate;
        this.mainImagePath = mainImagePath;
        this.content = content;
        this.address = address;
        this.likeCount = 0L;
    }

    public void setWriter(User writer) {
        this.writer = writer;

        if(!writer.getWrittenPosts().contains(this)) {
            writer.getWrittenPosts().add(this);
        }
    }

    public void addLikeUser(User likeUser) {
        PostLikeUser postLikeUser = new PostLikeUser(this, likeUser);
        likeUsers.add(postLikeUser);
        likeUser.getLikePosts().add(postLikeUser);
    }
}

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
public class Feed {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "writerIdx")
    private User writer;                // 글 작성자
    @Column(nullable = true)
    private String updateDate;          // 글 생성일자 또는 변경일자
    @Column(nullable = true)
    private String mainImagePath;       // 글 메인 이미지 파일명(ex-filename.png)
    @Column(nullable = false)
    private String content;             // 글 내용
    @Column(nullable = false)
    private String address;             // 글 or 사진을 올린 장소
    @Column(nullable = false)
    private Long likeCount;             // 글 좋아요 개수

    @OneToMany(mappedBy = "feed")
    private final List<FeedLikeUser> likeUsers = new ArrayList<>();

    public Feed(User writer, String updateDate, String mainImagePath, String content, String address) {
        setWriter(writer);
        this.updateDate = updateDate;
        this.mainImagePath = mainImagePath;
        this.content = content;
        this.address = address;
        this.likeCount = 0L;
    }

    public void setWriter(User writer) {
        this.writer = writer;

        if(!writer.getWrittenFeeds().contains(this)) {
            writer.getWrittenFeeds().add(this);
        }
    }

    public void addLikeUser(User likeUser) {
        FeedLikeUser feedLikeUser = new FeedLikeUser(this, likeUser);
        likeUsers.add(feedLikeUser);
        likeUser.getLikeFeeds().add(feedLikeUser);
    }
}

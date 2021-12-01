package com.sparta.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.dangdang.dto.FeedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Feed extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;                    // ID

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User nickName;              // 사용자 아이디

    @Column(nullable = true)
    private String createTime;          // 글 생성일자 또는 변경일자
    @Column(nullable = true)
    private String mainImagePath;       // 글 메인 이미지 파일명(ex-filename.png)
    @Column(nullable = false)
    private String content;             // 글 내용
    @Column(nullable = false)
    private String address;             // 글 or 사진을 올린 장소
    @Column(nullable = false)
    private String size;                // 강아지 크기
    @Column(nullable = false)
    private Long likeCount;             // 글 좋아요 개수

    public Feed(FeedDto feedDto, User nickName){
        this.idx = feedDto.getIdx();
        this.createTime = feedDto.getCreateTime();
        this.mainImagePath = feedDto.getMainImagePath();
        this.content = feedDto.getContent();
        this.address = feedDto.getAddress();
        this.size = feedDto.getSize();
        this.likeCount = feedDto.getLikeCount();
        this.nickName = nickName;
    }

}


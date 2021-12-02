package com.sparta.dangdang.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedDetailResponseDto {
    private Long feedIdx;
    private String mainImage;
    private Boolean like;
    private Long likeCount;
    private String nickName;
    private String updateTime;
    private String userProfileImg;
    private String address;
    private String content;
    // private Reply[] repleList;
}

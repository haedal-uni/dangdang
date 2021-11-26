package com.sparta.dangdang.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailResponseDto {
    private Long post_idx;
    private String main_image;
    private Boolean like;
    private Long like_count;
    private String user_id;
    private String update_time;
    private String user_profile_img;
    private String address;
    private String content;
    // private Reply[] repleList;
}

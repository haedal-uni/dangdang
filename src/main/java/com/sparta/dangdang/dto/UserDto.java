package com.sparta.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String NickName;          // 사용자 아이디
    private String ProfileImg;      // 프로필 사진
}

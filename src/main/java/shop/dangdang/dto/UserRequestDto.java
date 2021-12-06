package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String NickName;          // 사용자 아이디
    private String ProfileImg;      // 프로필 사진
}

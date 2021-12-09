package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MainPageDto {
    private String address;
    private String content;
    private String puppy;
    private MultipartFile image;
    private String nickName;
    private MultipartFile profileimage;

    public MainPageDto(String image, String content, String nickName, String profileImgUrl) {
    }

}

package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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

    public MainPageDto(String image, String content, String nickName) {
    }

}

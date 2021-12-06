package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadDto {
    private String address;
    private String content;         // 게시 글
    private MultipartFile image;    // 이미지 파일
}

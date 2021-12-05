package shop.dangdang.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class UploadDto {
    private String content;
    private MultipartFile image;
}

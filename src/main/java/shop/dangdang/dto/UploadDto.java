package com.sparta.dangdang.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class UploadDto {
    private String content;
    private MultipartFile file;
    //private String file;
}

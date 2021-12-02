package com.sparta.dangdang.controller;

import com.sparta.dangdang.domain.Upload;
import com.sparta.dangdang.dto.UploadDto;
import com.sparta.dangdang.service.S3Uploader;
import com.sparta.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/api/upload")
    public Upload setUpload(UploadDto uploadDto){
        return uploadService.setUpload(uploadDto);
    }



    private final S3Uploader s3Uploader;
    @PostMapping("/images")
    public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        s3Uploader.upload(multipartFile, "static");
        return "test";
    }

}



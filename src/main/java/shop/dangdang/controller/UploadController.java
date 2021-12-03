package shop.dangdang.controller;

import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.service.S3Uploader;
import shop.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;
    private final S3Uploader s3Uploader;

    @PostMapping("/api/upload")
    public Upload setUpload(UploadDto uploadDto){
        return uploadService.setUpload(uploadDto);
    }




    @PostMapping("/api/upload")
    public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        s3Uploader.upload(multipartFile, "static");
        return "test";
    }

}



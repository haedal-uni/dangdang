package shop.dangdang.controller;

import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.service.S3Uploader;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@RequiredArgsConstructor
@RestController
public class UploadController {
    private final S3Uploader s3Uploader;
    private final UploadService uploadService;

    @PostMapping("/api/upload")
    public Upload setUpload(UploadDto uploadDto){
        return uploadService.setUpload(uploadDto);
    }


//    @PostMapping("/api/upload")
//    @ResponseBody
//    public String upload(@RequestParam("form_data") MultipartFile multipartFile) throws IOException {
//        return s3Uploader.upload(multipartFile, "static");
//    }

//    @PostMapping("/api/upload")
//    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//        s3Uploader.upload(multipartFile, "static");
//        return "test";
//    }

}



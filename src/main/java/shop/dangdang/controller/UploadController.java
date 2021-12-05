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


    private final UploadService uploadService;

//    @PostMapping("/api/upload")
//    public Upload setUpload(UploadDto uploadDto){
//        return uploadService.setUpload(uploadDto);
//    }


    @PostMapping("/api/upload")
    public Upload setUpload(@ModelAttribute UploadDto uploadDto) throws IOException{
        System.out.println(uploadDto.getImage().getOriginalFilename());
        return uploadService.setUpload(uploadDto);
    }
}



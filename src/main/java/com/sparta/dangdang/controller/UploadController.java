package com.sparta.dangdang.controller;

import com.sparta.dangdang.domain.Upload;
import com.sparta.dangdang.dto.UploadDto;
import com.sparta.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/api/upload")
    //public Upload setUpload(@RequestBody UploadDto uploadDto)
    public Upload setUpload(UploadDto uploadDto, @RequestPart(value = "file", required = false) MultipartFile image){
        return uploadService.setUpload(uploadDto);
    }

}
//    @PostMapping("/api/upload/image"){
//        public Upload setPhoto(@RequestBody PhotoDto photoDto {
//            return uploadService.setPhoto(photoDto);
//        }
    //}
    //@GetMapping("/api/upload")


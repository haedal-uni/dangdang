package com.sparta.dangdang.controller;

import com.sparta.dangdang.domain.Upload;
import com.sparta.dangdang.dto.UploadDto;
import com.sparta.dangdang.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/api/upload")
    public Upload setUpload(@RequestBody UploadDto uploadDto){
        return uploadService.setUpload(uploadDto);
    }

    //@GetMapping("/api/upload")
}

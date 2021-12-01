package com.sparta.dangdang.service;

import com.sparta.dangdang.domain.Upload;
import com.sparta.dangdang.dto.UploadDto;
import com.sparta.dangdang.repository.UploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UploadService {

    private final UploadRepository uploadRepository;

    @Transactional
    public Upload setUpload(UploadDto uploadDto) {
        Upload upload = new Upload(uploadDto);
        uploadRepository.save(upload);
        return upload;
    }

//    @Transactional
//    public setPhoto(PhotoDto photoDto {
//        Upload upload = new Upload(uploadDto);
//        uploadRepository.save(upload);
//        return upload;
//    }
}

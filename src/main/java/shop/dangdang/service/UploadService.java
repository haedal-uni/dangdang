package shop.dangdang.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.repository.UploadRepository;

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
}

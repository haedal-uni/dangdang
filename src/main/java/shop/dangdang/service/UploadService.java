package shop.dangdang.service;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.repository.UploadRepository;
import javax.transaction.Transactional;
import java.io.IOException;


@RequiredArgsConstructor
@Service
public class UploadService {
    private final S3Uploader s3Uploader;
    private final UploadRepository uploadRepository;

    @Transactional
    public Upload setUpload(UploadDto uploadDto) throws IOException{

        String image = s3Uploader.upload(uploadDto.getImage(),"dang");

        Upload upload = new Upload(uploadDto,image);
        uploadRepository.save(upload);
        return upload;
    }





}

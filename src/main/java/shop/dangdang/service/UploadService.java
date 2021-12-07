package shop.dangdang.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.repository.UploadRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
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

    // 테스트
    public Upload doTest(Long idx) {
        Upload test = uploadRepository.findById(idx).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        return test;
    }


    // 사진 정보 main page로 가져오기
    public List<Upload> getmaininfo() {
        List<Upload> allinfo = uploadRepository.findAll();
        return allinfo;
    }

    // 사진 정보 photo page로 가져오기
    public List<Upload> getphotos(Long addressId) {
        List<Upload> allPhoto = uploadRepository.findByaddressId(addressId);
        return allPhoto;
    }
}

package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Upload;
import shop.dangdang.dto.UploadDto;
import shop.dangdang.repository.UploadRepository;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

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

    // 테스트
    public Upload doTest(Long idx) {
        Upload test = uploadRepository.findById(idx).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        return test;
    }


    // 테스트2
    public List<Upload> doTest2() {
        List<Upload> allTest = uploadRepository.findAll();
        return allTest;
    }
}

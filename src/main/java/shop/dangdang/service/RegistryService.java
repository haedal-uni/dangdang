package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Registry;
import shop.dangdang.dto.RegistryDto;
import shop.dangdang.repository.RegistryRepository;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RegistryService {
    private final S3Uploader s3Uploader;
    private final RegistryRepository registryRepository;

    @Transactional
    public Registry setUpload(RegistryDto uploadDto) throws IOException{
        String image = s3Uploader.upload(uploadDto.getImage(),"dang");
        Registry upload = new Registry(uploadDto,image);
        registryRepository.save(upload);
        return upload;
    }

    // 테스트
    public Registry doTest(Long idx) {
        Registry test = registryRepository.findById(idx).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        return test;
    }

    // 테스트2
    public List<Registry> doTest2() {
        List<Registry> allTest = registryRepository.findAll();
        return allTest;
    }

}

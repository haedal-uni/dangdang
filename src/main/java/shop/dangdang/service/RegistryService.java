package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
import shop.dangdang.dto.MembershipDto;
import shop.dangdang.dto.RegistryDto;
import shop.dangdang.repository.MembershipRepository;
import shop.dangdang.repository.RegistryRepository;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RegistryService {
    private final S3Uploader s3Uploader;
    private final RegistryRepository registryRepository;
    private final MembershipRepository membershipRepository;

    @Transactional
    public Registry setUpload(RegistryDto uploadDto) throws IOException{
        String image = s3Uploader.upload(uploadDto.getImage(),"dang");
        Registry upload = new Registry(uploadDto,image);
        registryRepository.save(upload);
        return upload;
    }

    //회원가입할 때 정보 가져오기
    public Membership getMembership(MembershipDto membershipDto) {
        return membershipRepository.findByNickname(membershipDto.getNickName()).orElseThrow(
                () -> new NullPointerException("해당 닉네임이 존재하지 않습니다.")
        );
    }

    // 등록한 사진 가져오기
    public List<Registry> photos() {
        List<Registry> photos = registryRepository.findAll();
        return photos;
    }

}

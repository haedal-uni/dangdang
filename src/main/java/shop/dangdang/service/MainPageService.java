package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
import shop.dangdang.dto.MainPageDto;
import shop.dangdang.repository.MembershipRepository;
import shop.dangdang.repository.RegistryRepository;

@RequiredArgsConstructor
@Service
public class MainPageService {
    private final RegistryRepository registryRepository;
    private final MembershipRepository membershipRepository;

    // 사진 정보 main 페이지로 가져오기(전체)
    public MainPageDto getMainInfo(Long registryIdx) {
        Registry registries = registryRepository.findById(registryIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

        Membership memberships = membershipRepository.findById(registryIdx).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );

//        List<Registry> registries = registryRepository.findAll();
//        List<Membership> memberships = membershipRepository.findAll();

        MainPageDto mainPageDto = new MainPageDto(registries.getImage(), registries.getContent(), memberships.getNickName(), memberships.getProfileImgUrl());

        return mainPageDto;
    }

//    // 사용자 정보(사진,별명) main 페이지로 가져오기(전체)
//    public List<Membership> getUserMainInfo() {
//        List<Membership> memberships = membershipRepository.findAll();
//        return memberships;
//    }
}

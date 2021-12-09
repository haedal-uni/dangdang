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
                () -> new NullPointerException("해당 아이디가 없습니다.")
        );

        Membership memberships = membershipRepository.findById(registryIdx).orElseThrow(
                () -> new NullPointerException("해당 아이디가 없습니다.")
        );

        MainPageDto mainPageDto = new MainPageDto(registries.getImage(), registries.getContent(), memberships.getNickName());

        return mainPageDto;
    }
}

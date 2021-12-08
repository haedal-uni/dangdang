package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;
import shop.dangdang.repository.MembershipRepository;
import shop.dangdang.repository.RegistryRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainPageService {
    private final RegistryRepository registryRepository;
    private final MembershipRepository membershipRepository;

    // 사진 정보 main 페이지로 가져오기(전체)
    public List<Registry> getMainInfo() {
        List<Registry> registries = registryRepository.findAll();
        return registries;
    }

    // 사용자 정보(사진,별명) main 페이지로 가져오기(전체)
    public List<Membership> getUserMainInfo() {
        List<Membership> memberships = membershipRepository.findAll();
        return memberships;
    }
}

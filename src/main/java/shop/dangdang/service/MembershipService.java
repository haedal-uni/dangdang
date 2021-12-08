package shop.dangdang.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dangdang.domain.Membership;
import shop.dangdang.repository.MembershipRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MembershipService {
    private final MembershipRepository membershipRepository;

    //회원가입할 때 정보 가져오기
    public List<Membership> puppy() {
        List<Membership> puppy = membershipRepository.findAll();
        return puppy;
    }
}

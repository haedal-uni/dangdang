package shop.dangdang.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dangdang.domain.Authority;
import shop.dangdang.domain.Membership;
import shop.dangdang.dto.JoinDto;
import shop.dangdang.repository.MembershipRepository;
import shop.dangdang.util.SecurityUtil;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtService {
    private final MembershipRepository membershipRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtService(MembershipRepository membershipRepository, PasswordEncoder passwordEncoder) {
        this.membershipRepository = membershipRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 가입하기 전 가입 여부를 확인하고 없으면 저장한다.
    @Transactional
    public Membership join(JoinDto.Request requestDto) {
        if (membershipRepository.findOneWithAuthoritiesBynickName(requestDto.getNickName()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")         // 일반 사용자 권한 사용
                .build();

        Membership user = Membership.builder()
                .nickName(requestDto.getNickName())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .email(requestDto.getEmail())
                .activated(true)
                .authorities(Collections.singleton(authority))
                .build();

        return membershipRepository.save(user);
    }
}

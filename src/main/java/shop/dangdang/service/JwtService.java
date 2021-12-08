package shop.dangdang.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dangdang.domain.Authority;
import shop.dangdang.domain.Membership;
import shop.dangdang.dto.UserJoinDto;
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

    @Transactional
    public Membership signup(UserJoinDto.Request requestDto) {
        if (membershipRepository.findOneWithAuthoritiesBynickName(requestDto.getNickName()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
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

    @Transactional(readOnly = true)
    public Optional<Membership> getUserWithAuthorities(String username) {
        return membershipRepository.findOneWithAuthoritiesBynickName(username);
    }

    @Transactional(readOnly = true)
    public Optional<Membership> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(membershipRepository::findOneWithAuthoritiesBynickName);
    }
}

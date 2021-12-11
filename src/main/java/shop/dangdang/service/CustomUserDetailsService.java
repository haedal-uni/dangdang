package shop.dangdang.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shop.dangdang.domain.Membership;
import shop.dangdang.repository.MembershipRepository;

import java.util.List;
import java.util.stream.Collectors;

// 시큐리티에 사용자 관련 서비스를 미리 정의해두어서 이 클래스를 확장해서 사용한다.
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final MembershipRepository membershipRepository;

    public CustomUserDetailsService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    // 사용자 정보를 불러들이는 부분
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        return membershipRepository.findOneWithAuthoritiesBynickName(username)
                .map(user -> createUser(username, user))
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    // 사용자 정보를 토대로 스프링 시큐티 사용자로 변환
    private org.springframework.security.core.userdetails.User createUser(String username, Membership user) {
        if (!user.isActivated()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getNickName(), user.getPassword(), grantedAuthorities);
    }
}
package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Membership;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByNickname(String nickname);
}//JPA 쿼리 메소드
//Optional은 하나의 데이터만 가져온다.


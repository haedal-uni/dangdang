package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}


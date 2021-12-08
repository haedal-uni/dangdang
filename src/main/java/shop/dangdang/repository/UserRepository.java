package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickName(String userNickName);
}

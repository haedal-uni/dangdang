package shop.dangdang.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.FeedLikeUser;

public interface FeedLikeUserRepository extends JpaRepository<FeedLikeUser, Long> {
    FeedLikeUser findByUserIdx(Long feedIdx);
}

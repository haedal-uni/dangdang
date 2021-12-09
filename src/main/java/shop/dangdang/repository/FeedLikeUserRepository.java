package shop.dangdang.repository;


import shop.dangdang.domain.FeedLikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedLikeUserRepository extends JpaRepository<FeedLikeUser, Long> {
    FeedLikeUser findByUserIdx(Long feedIdx);
}

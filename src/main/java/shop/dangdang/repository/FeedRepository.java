package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}

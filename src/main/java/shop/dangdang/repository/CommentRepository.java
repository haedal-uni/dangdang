package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

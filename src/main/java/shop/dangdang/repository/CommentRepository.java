package shop.dangdang.repository;

import shop.dangdang.domain.Comment;
import shop.dangdang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

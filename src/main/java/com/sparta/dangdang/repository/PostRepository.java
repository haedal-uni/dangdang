package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

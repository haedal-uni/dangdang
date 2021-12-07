package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}

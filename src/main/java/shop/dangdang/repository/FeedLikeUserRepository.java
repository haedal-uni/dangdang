package com.sparta.dangdang.repository;


import com.sparta.dangdang.domain.FeedLikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedLikeUserRepository extends JpaRepository<FeedLikeUser, Long> {
    FeedLikeUser findByUserIdx(Long feedIdx);
}

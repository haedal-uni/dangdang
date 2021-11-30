package com.sparta.dangdang.repository;


import com.sparta.dangdang.domain.FeedLikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedLikeUserRepository extends JpaRepository<FeedLikeUser, Long> {
    List<FeedLikeUser> findByUserIdx(Long feedIdx);
}

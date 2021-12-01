package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    List<Feed> findAllByNickName(Feed feed);
}


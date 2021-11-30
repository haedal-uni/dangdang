package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.domain.PostLikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeUserRepository extends JpaRepository<PostLikeUser, Long> {

}

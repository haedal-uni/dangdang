package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Post;
import com.sparta.dangdang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.sparta.dangdang.repository;

import com.sparta.dangdang.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}

package shop.dangdang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Upload;

import java.util.List;

public interface UploadRepository extends JpaRepository<Upload, Long> {
    List<Upload> findByaddressId(Long addressId);
}

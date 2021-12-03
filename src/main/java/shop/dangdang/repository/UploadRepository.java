package shop.dangdang.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Upload;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}

package shop.dangdang.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
}

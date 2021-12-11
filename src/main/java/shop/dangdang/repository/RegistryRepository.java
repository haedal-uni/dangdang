package shop.dangdang.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;

import java.util.Optional;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}

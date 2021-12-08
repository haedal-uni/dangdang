package shop.dangdang.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import shop.dangdang.domain.Membership;
import shop.dangdang.domain.Registry;

import java.util.List;

@Data
public class MainPageDto {
    private List<Registry> registries;
    private List<Membership> memberships;
}

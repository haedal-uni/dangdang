package shop.dangdang.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.dangdang.dto.RegistryDto;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Registry extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "RegistryId")
    private Long idx;

    @Column(nullable = true)
    private String nickname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String puppy;

    @Column(nullable = false)
    private String image;

    public Registry(RegistryDto uploadDto, String image) {
        this.address = uploadDto.getAddress();
        this.content = uploadDto.getContent();
        this.puppy = uploadDto.getPuppy();
        this.image = image;
    }
}


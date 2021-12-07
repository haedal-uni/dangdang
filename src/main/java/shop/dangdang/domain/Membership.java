package shop.dangdang.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Membership {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String puppy;

}

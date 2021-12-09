package shop.dangdang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import shop.dangdang.domain.Feed;
import shop.dangdang.service.FeedDetailService;

@EnableJpaAuditing
@SpringBootApplication
public class DangDangApplication {


    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties,"
            + "classpath:aws.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(DangDangApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);

        System.out.println("1234");

        //        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();
//
//        Membership user = new Membership("manijang2", passwordEncoder.encode("1234"), "manijang2@naver.com", true, Collections.singleton(authority));
//        membershipRepository.save(user);
    }
}
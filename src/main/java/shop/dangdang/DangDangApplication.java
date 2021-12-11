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
    }
}
package com.sparta.dangdang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DangDangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangDangApplication.class, args);
    }

}

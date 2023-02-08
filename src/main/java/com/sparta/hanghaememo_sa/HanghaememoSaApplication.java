package com.sparta.hanghaememo_sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaememoSaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaememoSaApplication.class, args);
    }

}

package org.hanghae.hanghaetask1reviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaeTask1ReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeTask1ReviewServiceApplication.class, args);
    }

}

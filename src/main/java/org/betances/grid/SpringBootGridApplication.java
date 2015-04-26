package org.betances.grid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootGridApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGridApplication.class, args);
    }
}

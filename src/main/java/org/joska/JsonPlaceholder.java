package org.joska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
//@EnableJpaRepositories
//@ComponentScan(basePackages = { "org.joska.repository.*" })
//@EntityScan(basePackages = { "org.joska.model.user.domain", "org.joska.model.album" })
//@EnableAutoConfiguration
//@EnableJpaRepositories("org.joska.*")
//@ComponentScan(basePackages = { "org.joska.*" })
//@EntityScan("org.joska.*")
public class JsonPlaceholder {
    public static void main(String[] args) {
        SpringApplication.run(JsonPlaceholder.class, args);
    }
}
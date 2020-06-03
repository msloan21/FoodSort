package com.mgmtp.foodsort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.mgmtp.foodsort")
@EnableJpaRepositories("com.mgmtp.foodsort.repository")
@EntityScan("com.mgmtp.foodsort.model")
@EnableWebMvc
public class WebApplication {
	public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}

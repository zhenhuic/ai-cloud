package com.chenzhenhui.aicloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class AiCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCloudApplication.class, args);
    }

}

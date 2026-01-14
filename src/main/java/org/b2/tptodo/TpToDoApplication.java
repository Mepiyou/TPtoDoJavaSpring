package org.b2.tptodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.b2.tptodo", "controller", "service", "repository", "exceptionHttp"})
public class TpToDoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpToDoApplication.class, args);
    }

}

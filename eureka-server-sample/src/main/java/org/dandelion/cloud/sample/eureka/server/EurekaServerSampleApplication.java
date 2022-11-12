package org.dandelion.cloud.sample.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSampleApplication.class, args);
    }

}

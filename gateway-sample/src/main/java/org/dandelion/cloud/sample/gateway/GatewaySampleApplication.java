package org.dandelion.cloud.sample.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySampleApplication.class, args);
    }

}

package org.dandelion.cloud.sample.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientSampleApplication.class, args);
    }

}

package org.dandelion.cloud.sample.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SleuthSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthSampleApplication.class, args);
    }

}

package me.sathish.mynewresume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MynewresumeDiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MynewresumeDiscoveryServerApplication.class, args);
    }

}

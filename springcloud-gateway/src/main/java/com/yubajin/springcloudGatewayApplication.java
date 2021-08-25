package com.yubajin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class springcloudGatewayApplication {
    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:8888/gateway/echo?name=yubajin");
        SpringApplication.run(springcloudGatewayApplication.class, args);
    }
}

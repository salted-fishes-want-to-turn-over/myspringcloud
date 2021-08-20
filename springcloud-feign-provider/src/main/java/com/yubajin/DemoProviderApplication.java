package com.yubajin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProviderApplication {

    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:14273/echo?name=yubajin");
        SpringApplication.run(DemoProviderApplication.class, args);
    }

}

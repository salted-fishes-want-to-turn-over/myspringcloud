package cn.yubajin.demo.springcloudnacosdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigClientApplication.class, args);
        System.out.println("客户端请求时读取springcloud配置");
        System.out.println("http://localhost:8080/demo/test02");
    }

}

package cn.yubajin.demo.springcloudnacosprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringcloudNacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudNacosProviderApplication.class, args);
        System.out.println("nacos discovery provider");
        System.out.println("http://127.0.0.1:18080/echo?name=yubajin");
    }

    @RestController
    static class TestController {

        @GetMapping("/echo")
        public String echo(String name) {
            return "provider:" + name;
        }

    }

}

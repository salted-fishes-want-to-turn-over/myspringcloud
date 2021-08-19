package cn.yubajin.demo.springcloudnacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcloudNacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudNacosClientApplication.class, args);

        System.out.println("请求时读取nacos配置");
        System.out.println("http://localhost:9901/demo/test02\n" +
                "http://localhost:9901/autoRefresh/test_properties");
    }

}

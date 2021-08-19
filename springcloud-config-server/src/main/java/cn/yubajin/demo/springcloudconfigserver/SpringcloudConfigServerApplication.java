package cn.yubajin.demo.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfigServerApplication {

    public static void main(String[] args) {
        /***
         * URL和配置文件的映射关系
         * * /{application}/{profile}/{lable}
         * * /{application}-{profile}.properties/yml.json
         * * /{lable}/{application}-{profile}
         */
        SpringApplication.run(SpringcloudConfigServerApplication.class, args);
        System.out.println("服务端查看配置： http://127.0.0.1:8888/user-application.yml");
        System.out.println("服务端查看配置： http://127.0.0.1:8888/user-application.properties/json");
    }

}

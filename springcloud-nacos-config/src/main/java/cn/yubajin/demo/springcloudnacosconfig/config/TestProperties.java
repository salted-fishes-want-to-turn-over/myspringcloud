package cn.yubajin.demo.springcloudnacosconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "xiaoyu")
public class TestProperties {

    /**
     * 测试属性
     */
    private String test;

    // ... 省略 set/get 方法

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

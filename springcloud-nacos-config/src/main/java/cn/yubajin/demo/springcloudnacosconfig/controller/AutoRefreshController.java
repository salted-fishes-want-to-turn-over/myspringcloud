package cn.yubajin.demo.springcloudnacosconfig.controller;

import cn.yubajin.demo.springcloudnacosconfig.config.TestProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autoRefresh")
@RefreshScope
public class AutoRefreshController {

    //    @Value("${test}")
    @NacosValue(value = "${xiaoyu.test}", autoRefreshed = true)
    private String test;

    @GetMapping("/test")
    public String test() {
        return this.test;
    }

    @Autowired
    private TestProperties testProperties;

    @GetMapping("/test_properties")
    public TestProperties testProperties() {
        return testProperties;
    }

}

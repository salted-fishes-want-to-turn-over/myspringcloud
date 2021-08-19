package cn.yubajin.demo.springcloudnacosconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * 为什么我们这里注释掉了呢？因为我们在「2.2 配置文件」中，
 * 设置了 nacos.config.bootstrap.enable=true，Spring Boot 应用在启动时，
 * 预加载了来自 Nacos 配置，所以可以直接使用 @ConfigurationProperties 注解即可。
 * 这样的好处，是可以更加通用，而无需和 Nacos 有耦合与依赖。
 */

@Component
@ConfigurationProperties(prefix = "order")  //可以读取前缀为 order 配置项，设置到配置类对应的属性上。
// @NacosConfigurationProperties(prefix = "order", dataId = "${nacos.config.data-id}", type = ConfigType.YAML)
public class OrderProperties {
    /**
     * 订单支付超时时长，单位：秒。
     */
    private Integer payTimeoutSeconds;

    /**
     * 订单创建频率，单位：秒
     */
    private Integer createFrequencySeconds;

    // ... 省略 set/get 方法

    public Integer getPayTimeoutSeconds() {
        return payTimeoutSeconds;
    }

    public void setPayTimeoutSeconds(Integer payTimeoutSeconds) {
        this.payTimeoutSeconds = payTimeoutSeconds;
    }

    public Integer getCreateFrequencySeconds() {
        return createFrequencySeconds;
    }

    public void setCreateFrequencySeconds(Integer createFrequencySeconds) {
        this.createFrequencySeconds = createFrequencySeconds;
    }

}

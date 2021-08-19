package cn.yubajin.demo.springcloudnacosdiscovery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order")  //可以读取前缀为 order 配置项，设置到配置类对应的属性上。
public class OrderProperties {
    /**
     * 订单支付超时时长，单位：秒。
     */
    private Integer payTimeoutSeconds;

    /**
     * 订单创建频率，单位：秒
     */
    private Integer createFrequencySeconds;

    private String ceshila;

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

    public String getCeshila() {
        return ceshila;
    }

    public void setCeshila(String ceshila) {
        this.ceshila = ceshila;
    }
}

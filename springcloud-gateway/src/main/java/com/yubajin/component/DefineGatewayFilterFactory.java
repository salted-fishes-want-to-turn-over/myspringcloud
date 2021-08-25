package com.yubajin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class DefineGatewayFilterFactory extends AbstractGatewayFilterFactory<DefineGatewayFilterFactory.Config> {

    Logger logger= LoggerFactory.getLogger(DefineGatewayFilterFactory.class);

    public DefineGatewayFilterFactory() {
        super(Config.class);
    }

    public static final String NAME_KEY="name";

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        //TODO 过滤的核心逻辑
        return ((exchange, chain) -> {
            logger.info("[Pred] Filter Request，Name:"+config.getName());
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                String code = exchange.getResponse().toString();
                logger.info("[Post] Response Filter"+code);
            }));
        });
    }

    public static class Config{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

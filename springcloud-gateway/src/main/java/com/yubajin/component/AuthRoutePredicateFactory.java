package com.yubajin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    Logger logger= LoggerFactory.getLogger(AuthRoutePredicateFactory.class);

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    public static final String NAME_KEY="name";

    @Override
    public List<String> shortcutFieldOrder() { // 快捷访问方式
        return Arrays.asList(NAME_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        logger.info("AuthRoutePrecdicateFactory.apply");
        return exchange ->{   // lamda表达式
            HttpHeaders headers=exchange.getRequest().getHeaders();
            List<String> headerList=headers.get(config.getName()); //来自于配置文件中配置的匹配规则
            return (headerList==null||headerList.size()<=0)?false:true;
        };
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

package com.yubajin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/****************
 * 全局过滤器，不需要配置，属于全局
 */
@Component
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter, Ordered {
    Logger logger= LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("【PRE】");

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            logger.info("【POST】");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

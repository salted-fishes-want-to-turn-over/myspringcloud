package com.myspringcloud.demo.springcloudnetflixribboncustomer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * 自定义ribbon策略来做负载均衡
 **/
public class MyDefineIpHashRule extends AbstractLoadBalancerRule{

    Logger log= LoggerFactory.getLogger(MyDefineIpHashRule.class);

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }
    public Server choose(ILoadBalancer lb,Object key){
        log.info("MyDefineIpHashRul:"+key);
        if(lb==null){
            return null;
        }
        List<Server> upList=lb.getReachableServers(); //获得可用的服务实例列表
        List<Server> allList=lb.getAllServers(); //获得所有的服务实例列表
        int serverCount=allList.size();
        if(serverCount==0){
            return null;
        }
        int index=ipAddressHash(serverCount);
        return upList.get(index);
    }
    private int ipAddressHash(int serverCount){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String remoteAddr=servletRequestAttributes.getRequest().getRemoteAddr();
        int code=Math.abs(remoteAddr.hashCode());
        return code%serverCount;
    }
}

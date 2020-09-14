package com.wyq.gateway.filter;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //可以在这里统一鉴权，统一限流

        //ServerWebExchange相当于当前请求和响应的上下文，通过它可以获取到request和response对象
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null || "".equals(token.trim())){
            System.out.println("token is null");
            //认证不通过
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //到此结束，不转发请求
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

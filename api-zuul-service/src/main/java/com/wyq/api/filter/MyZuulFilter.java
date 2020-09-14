package com.wyq.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1.获取到请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.根据上下文对象，获取对应的请求对象或响应对象
        HttpServletRequest request = currentContext.getRequest();
        System.out.println("--->拦截请求：" + request.getRequestURI());
        //3.假设请求的路劲必须包含token认证信息
        String token = request.getParameter("token");
        if(token==null || "".equals(token.trim())){
                //不在往下调用，采用response的方式给予客户端响应
            currentContext.setSendZuulResponse(false);
            try {
                currentContext.getResponse().getWriter().print("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MyZuulFilter......");
        return null;
    }
}

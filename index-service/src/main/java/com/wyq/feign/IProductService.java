package com.wyq.feign;

import com.wyq.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE",fallback = IProductService.ProductServiceCallback.class)
public interface IProductService {

    //正常的调用逻辑
    @GetMapping("product/list")
    public List<Product> list();

    //添加兜底方案
    @Component
    static class ProductServiceCallback implements IProductService{

        @Override
        public List<Product> list() {
            System.out.println("进入Hystrix熔断处理逻辑...");
            return new ArrayList<>();
        }
    }
}

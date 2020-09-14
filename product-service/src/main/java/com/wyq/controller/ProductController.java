package com.wyq.controller;

import com.wyq.entity.Product;
import com.wyq.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private IProductService productService;

    @GetMapping("list")
    @ResponseBody
    public List<Product> list(){
        log.info(serverPort);
        return productService.list();
    }
}

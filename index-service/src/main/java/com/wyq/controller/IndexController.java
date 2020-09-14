package com.wyq.controller;

import com.wyq.entity.Product;
import com.wyq.feign.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IProductService productService;

    private String INDEX_SERVICE_URL = "http://PRODUCT-SERVICE/product/list";

    @RequestMapping("show")
    @ResponseBody
    public List<Product> show(Model model){
        /*RestTemplate restTemplate = new RestTemplate();*/
        //String list = restTemplate.getForObject(INDEX_SERVICE_URL,String.class);
        //model.addAttribute("list",list);
        List<Product> list = productService.list();
        return list;
        //return new ArrayList<>();
    }

}

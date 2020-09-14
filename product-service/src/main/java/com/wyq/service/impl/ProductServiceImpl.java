package com.wyq.service.impl;
import	java.util.ArrayList;

import com.wyq.entity.Product;
import com.wyq.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L,"开心",100L));
        list.add(new Product(2L,"高薪",1000L));
        return list;
    }
}

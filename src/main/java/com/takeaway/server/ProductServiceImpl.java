package com.takeaway.server;

import com.takeaway.mapper.ProductMapper;
import com.takeaway.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ProductService")
public class ProductServiceImpl {

    ProductMapper productMapper = null;

    public List<Product> queryAll(){
        return productMapper.queryAll();
    };
}

package com.takeaway.server;

import com.takeaway.mapper.ProductMapper;
import com.takeaway.pojo.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductServiceImpl {

    ProductMapper productMapper;

    public List<Product> queryAll(){
        return productMapper.queryAll();
    };
}

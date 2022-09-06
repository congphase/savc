package com.outletsvclone.savc.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // telling that this class is instantiated (it is a Spring bean)
public class ProductService {
    public List<ProductCategory> getProductCategoryTree() {
        List<ProductCategory> result = new ArrayList<>();

        ProductCategory mockProduct = new ProductCategory();

        result.add(mockProduct);

        return result;
    }
}

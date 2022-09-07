package com.outletsvclone.savc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // telling that this class is instantiated (it is a Spring bean)
public class ProductCategoryService {

    private final ProductCategoryRepository productRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productRepository) {
        this.productRepository = productRepository;
    }

    //// Intended for testing database only
    public List<ProductCategory> getProductCategoryAll() {
        return productRepository.findAll();
    }

    public List<ProductCategory> getProductCategoryTree() {
        return productRepository.findAll();
    }

//    public List<ProductCategory> getProductCategoryTree() {
//        List<ProductCategory> result = new ArrayList<>();
//
//        ProductCategory mockProduct = new ProductCategory();
//
//        result.add(mockProduct);
//
//        return result;
//    }
}

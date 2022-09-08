package com.outletsvclone.savc.product;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping(value = "api/prods")
    public List<ProductCategory> getProductCategoryAll() {

        return productCategoryService.getProductCategoryAll();
    }

    @GetMapping(value = "api/prods-tree")
    public JSONObject getProductCategoryTree() {

        return productCategoryService.getProductCategoryTree();
    }

    @PostMapping(value = "api/add-prod-cat")
    public String addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.addNewProductCategory(productCategory);

        return "SUCCESS";
    }

    @GetMapping("api/mock-service")
    public List<String> testMockService() {
        return productCategoryService.mockService();
    }

}

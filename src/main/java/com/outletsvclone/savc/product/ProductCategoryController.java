package com.outletsvclone.savc.product;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "api/prods-by-condition")
    public List<ProductCategory> getProductCategoryByCondition(
            @RequestParam(name = "code", required = false) String code,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "parentCatId", required = false) String parentCodeId) {
        return productCategoryService.getProductCategoryByCondition(code, name, parentCodeId);
    }

    @PostMapping(value = "api/add-prod-cat")
    public String addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.addNewProductCategory(productCategory);
    }

    @DeleteMapping(path = "api/prods/{prodCatId}")
    public String deleteProductCategory(@PathVariable String prodCatId) {
        return productCategoryService.deleteProductCategory(prodCatId);
    }

    @PutMapping(path = "api/prods")
    public String updateProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(productCategory);
    }
}

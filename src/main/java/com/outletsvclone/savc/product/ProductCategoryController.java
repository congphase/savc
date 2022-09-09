package com.outletsvclone.savc.product;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "api/add-prod-cat")
    public ResponseEntity addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.addNewProductCategory(productCategory);

        return ResponseEntity.ok("CREATION SUCCESS!");
    } //// Consider changing return type from String to

    @DeleteMapping(path = "api/prods/{prodCatId}")
    public ResponseEntity deleteProductCategory(@PathVariable String prodCatId) {
        productCategoryService.deleteProductCategory(prodCatId);

        return ResponseEntity.ok("DELETE SUCCESS!");
    }

    @PutMapping(path = "api/prods")
    public ResponseEntity updateProductCategory(@RequestBody ProductCategory productCategory) {

        if(productCategoryService.updateProductCategory(productCategory)) {
            return ResponseEntity.ok("UPDATE SUCCESS FOR ID " + productCategory.getId());
        }
        return ResponseEntity.ok("UPDATE FAILED FOR ID " + productCategory.getId());
    }
}

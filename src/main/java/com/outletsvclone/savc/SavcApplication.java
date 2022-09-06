package com.outletsvclone.savc;

import com.outletsvclone.savc.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SavcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SavcApplication.class, args);
    }

//    // String
//    @GetMapping
//    public String productCategoryTree() {
//        return "Mock product categories";
//    }

    // List
    @GetMapping
    public List<Product> productCategoryTree() {
        List<Product> result = new ArrayList<Product>();

        return result;
    }
}

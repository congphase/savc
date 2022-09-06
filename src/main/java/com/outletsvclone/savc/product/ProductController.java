package com.outletsvclone.savc.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/prodCatTree")
public class ProductController {

    // List
    @GetMapping
    public List<Product> getProductCategoryTree() {
        List<Product> result = new ArrayList<Product>();

        Product mockProduct = new Product(1L,
                "B_DLANH",
                "Ngành Hàng Đông Lạnh",
                "",
                1,
                "Ngành Hàng Đông Lạnh",
                "",
                "",
                "CLMX",
                1,
                "2022-01-01 00:00:00.000",
                "SUPPER_ADMIN",
                "",
                ""
        );

        result.add(mockProduct);

        return result;
    }
}

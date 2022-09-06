package com.outletsvclone.savc.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // telling that this class is instantiated (it is a Spring bean)
public class ProductService {
    public List<Product> getProductCategoryTree() {
        List<Product> result = new ArrayList<>();

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

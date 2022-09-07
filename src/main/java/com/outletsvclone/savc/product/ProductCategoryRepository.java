package com.outletsvclone.savc.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.outletsvclone.savc.product.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // The below interface is responsible for data access
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

}

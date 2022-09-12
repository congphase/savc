package com.outletsvclone.savc.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // The below interface is responsible for data access
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findAllByParentCatId(String parentCatId);

    @Query(value = "SELECT id FROM product_category pc WHERE pc.depth = :depth ", nativeQuery = true)
    List<String> findAllByDepthEquals(@Param("depth") Integer depth);

    ProductCategory findProductCategoryByCodeAndNameAndParentCatId(String code, String name, String parentCatId);
}

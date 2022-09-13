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

    @Query("select pc from ProductCategory pc " +
            "where " +
            "    (:code is null or pc.code like CONCAT('%', :code, '%')) " +
            "and (:name is null or pc.name like CONCAT('%', :name, '%')) " +
            "and (:parentCatId is null or pc.parentCatId = :parentCatId)")
    List<ProductCategory> findProductCategoryByCondition(@Param("code") String code,
                                                         @Param("name") String name,
                                                         @Param("parentCatId") String parentCatId);

}
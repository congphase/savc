package com.outletsvclone.savc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service // telling that this class is instantiated (it is a Spring bean)
@Transactional
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductCategory> getProductCategoryAll() {
        return productRepository.findAll();
    }

    public List<ProductCategory> getProductCategoryByCondition(String code, String name, String parentCodeId) {
        List<ProductCategory> result;
        result = productRepository.findProductCategoryByCondition(code, name, parentCodeId);

        return result;
    }

    public JSONObject getProductCategoryTree() {
        List<String> interestedParentIds = productRepository.findAllByDepthEquals(1);

        JSONObject hierarchicalProds = new JSONObject();

        for (int i = 0; i < interestedParentIds.size(); i++) {
            String parent = interestedParentIds.get(i);
            List<ProductCategory> childs = productRepository.findAllByParentCatId(parent);

            hierarchicalProds.put(parent, childs);
        }
        return hierarchicalProds;
    }

    public String addNewProductCategory(ProductCategory productCategory) {
        List<ProductCategory> productCategoryList = productRepository.findProductCategoryByCondition(
                productCategory.getCode(),
                productCategory.getName(),
                productCategory.getParentCatId());

        if(0 < productCategoryList.size()) {
            return "Product category exists";
        }

        productRepository.saveAndFlush(productCategory);
        return "CREATION SUCCESS!";
    }

    public String deleteProductCategory(String prodCatId) {
        boolean exists = productRepository.existsById(prodCatId);

        if (!exists) {
            throw new IllegalStateException("PRODUCT CATEGORY DOES NOT EXIST TO DELETE!");
        }

        productRepository.deleteById(prodCatId);

        return "DELETION SUCCESS!";
    }

    public String updateProductCategory(ProductCategory productCategory) {
        Optional<ProductCategory> existingProCat = productRepository.findById(productCategory.getId());

        if (existingProCat.isPresent()) {
            ProductCategory toBeUpdated = existingProCat.get();

            toBeUpdated.setCode(productCategory.getCode());
            toBeUpdated.setName(productCategory.getName());
            toBeUpdated.setParentCatId(productCategory.getParentCatId());
            toBeUpdated.setDepth(productCategory.getDepth());
            toBeUpdated.setDescription(productCategory.getDescription());
            toBeUpdated.setImageUrl(productCategory.getImageUrl());
            toBeUpdated.setVisualIndex(productCategory.getVisualIndex());
            toBeUpdated.setTenantId(productCategory.getTenantId());
            toBeUpdated.setVersion(productCategory.getVersion());
            toBeUpdated.setCreateDate(productCategory.getCreateDate());
            toBeUpdated.setCreateUser(productCategory.getCreateUser());
            toBeUpdated.setUpdateDate(productCategory.getUpdateDate());
            toBeUpdated.setUpdateUser(productCategory.getUpdateUser());

            productRepository.saveAndFlush(toBeUpdated);

            return ("UPDATE SUCCESS FOR " + toBeUpdated.getId());
        }
        else {
            return "PRODUCT CATEGORY DOES NOT EXIST TO UPDATE!";
        }
    }
}

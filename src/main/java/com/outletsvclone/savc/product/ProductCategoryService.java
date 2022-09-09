package com.outletsvclone.savc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PutMapping;

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

    //// Intended for testing database only
    public List<ProductCategory> getProductCategoryAll() {
        return productRepository.findAll();
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

    public void addNewProductCategory(ProductCategory productCategory) {
        ProductCategory productCategoryByName = productRepository.findProductCategoryByName(productCategory.getName());

        if (productCategoryByName != null) {
            throw new IllegalStateException("Product category exists (name)");
        }

        productRepository.saveAndFlush(productCategory);
    }

    public void deleteProductCategory(String prodCatId) {
        boolean exists = productRepository.existsById(prodCatId);

        if (!exists) {
            throw new IllegalStateException("Product category does not exist to delete");
        }

        productRepository.deleteById(prodCatId);
    }

    public boolean updateProductCategory(ProductCategory productCategory) {
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

            return true;
        }
        else {
            throw new IllegalStateException("Product category does not exist to update");
        }
    }
}

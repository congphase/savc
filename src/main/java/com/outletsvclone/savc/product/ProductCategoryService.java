package com.outletsvclone.savc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;

import javax.transaction.Transactional;
import java.util.List;

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

        for(int i=0; i<interestedParentIds.size(); i++) {
            String parent = interestedParentIds.get(i);
            List<ProductCategory> childs = productRepository.findAllByParentCatId(parent);

            hierarchicalProds.put(parent, childs);
        }
        return hierarchicalProds;
    }

    public void addNewProductCategory(ProductCategory productCategory) {
        ProductCategory productCategoryByName =  productRepository.findProductCategoryByName(productCategory.getName());

        if(productCategoryByName != null) {
            throw new IllegalStateException("Product category exists (name)");
        }

        productRepository.saveAndFlush(productCategory);
    }

    public List<String> mockService() {

        return productRepository.findAllByDepthEquals(1);
    }

}

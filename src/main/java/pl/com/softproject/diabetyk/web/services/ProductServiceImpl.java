/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.softproject.diabetyk.web.dao.ProductCategoryDAO;
import pl.com.softproject.diabetyk.web.dao.ProductDAO;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 *
 * @author Adrian Lapierre
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private ProductDAO productDAO;
    
    @Transactional(readOnly = false)
    @Override
    public void saveProduct(Product product) {
        
        Set<ProductCategory> tmp = new HashSet<ProductCategory>(product.getCategories());
        product.getCategories().clear();
        
        for(ProductCategory cat : tmp) {
                cat = productCategoryDAO.findOne(cat.getId());
                cat.getProducts().add(product);
                product.getCategories().add(cat);
                //productCategoryDAO.save(cat);
            }
         productDAO.save(product);   
    }
    
    @Override
    public Iterable<ProductCategory> findAllCategoriesOrdered() {
        return productCategoryDAO.findAllOrdered();
    }
    
    @Override
    public Iterable<ProductCategory> findAllCategories() {
        return productCategoryDAO.findAll();
    }

    public void setProductCategoryDAO(ProductCategoryDAO productCategoryDAO) {
        this.productCategoryDAO = productCategoryDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    
    
}

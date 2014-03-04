/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import org.springframework.transaction.annotation.Transactional;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 *
 * @author Adrian Lapierre
 */
public interface ProductService {

    
    void saveProduct(Product product);

    Iterable<ProductCategory> findAllCategories();

    Iterable<ProductCategory> findAllCategoriesOrdered();
    
}

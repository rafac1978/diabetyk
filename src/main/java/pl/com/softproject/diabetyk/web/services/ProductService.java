/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Product> findProductsForModeration(String author, Pageable pr);

    Page<Product> findForUser(String author, Pageable pr);
    
}

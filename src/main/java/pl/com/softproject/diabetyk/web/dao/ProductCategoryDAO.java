/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 *
 * @author Adrian Lapierre
 */
public interface ProductCategoryDAO extends CrudRepository<ProductCategory, Long>{

    @Query("from ProductCategory order by name")
    public Iterable<ProductCategory> findAllOrdered();
    
}

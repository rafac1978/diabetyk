/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.com.softproject.diabetyk.web.model.Product;

/**
 *
 * @author Adrian Lapierre
 */
public interface ProductDAO extends CrudRepository<Product, Long> {

    public Product findByProductNormalizedName(String name);
    
    public Iterable<Product> findByModeratedTrue();
    
    @Query("select p from Product p where p.author.login = :author or moderated = true")
    public Page<Product> findForUser(@Param("author") String author, Pageable pageable);
    
    @Query("select p from Product p where p.author.login != :author and p.moderated = false")
    public Page<Product> findForModeration(@Param("author") String author, Pageable pageable);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.diabetyk.web.dao.ProductCategoryDAO;
import pl.com.softproject.diabetyk.web.dao.ProductDAO;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 *
 * @author Adrian Lapierre
 */
@ContextConfiguration("/diabetyk-web-core.xml")
@TransactionConfiguration(defaultRollback = false)
public class ProductServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private ProductService productService;
    
    @Test
    public void testSaveProductByService() {
       
        Product pr = new Product();
        pr.setName("test 2");
        pr.setDescription("lalalal");
        
        ProductCategory cat1 = new ProductCategory();
        cat1.setId(1L);
        cat1.setName("McDonlds");
        pr.getCategories().add(cat1);
        
        productService.saveProduct(pr);
        
    }
    
    /**
     * Test of saveProduct method, of class ProductServiceImpl.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        
        Product pr = new Product();
        pr.setName("test");
        pr.setDescription("lalalal");
        
        productDAO.save(pr);
        //productCategoryDAO.save(cat);
        
        ProductCategory cat = productCategoryDAO.findOne(1L);
        pr.getCategories().add(cat);
        cat.getProducts().add(pr);
        //cat.setName("amiana");
        
    }
    
    @Test
    public void test() {
        
        Product prod = productDAO.findOne(1L);
        
        prod.setName("zmiana nazwy");
        
        productDAO.save(prod);
        
    }

    
    
}

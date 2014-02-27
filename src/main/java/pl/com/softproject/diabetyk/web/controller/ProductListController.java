/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.diabetyk.web.dao.ProductDAO;
import pl.com.softproject.diabetyk.web.model.Product;

/**
 *
 * @author Adrian Lapierre
 */
@Controller
public class ProductListController {
    
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping("list")
    public ModelAndView showProducts() {
        
        ModelAndView model = new ModelAndView("product-list");
        final Iterable<Product> products = productDAO.findAll();
        
        System.out.println(products);
        
        List<Product> list = new ArrayList<Product>();
        for(Product p : products)
            list.add(p);
        
        model.addObject("products", products);
        
        return model;
    }
    
}

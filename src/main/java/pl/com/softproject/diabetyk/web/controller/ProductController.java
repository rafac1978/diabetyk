/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.diabetyk.web.dao.ProductCategoryDAO;
import pl.com.softproject.diabetyk.web.dao.ProductDAO;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 *
 * @author Adrian Lapierre
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductCategoryDAO productCategoryDAO;
    
    @Autowired
    private ProductDAO productDAO;
    
    
    @RequestMapping("/add")
    public ModelAndView addProduct() {
        
        ModelAndView model = new ModelAndView("add-product");
        model.addObject("product", new Product());
        addProductCategoryToModel(model);
        
        return model;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView saveProduct(@Valid Product product, BindingResult bindingResult) {
        
        ModelAndView model = new ModelAndView();
        
        if(bindingResult.hasErrors()) {
            model.setViewName("add-product");
            addProductCategoryToModel(model);
        } else {
            model.setViewName("redirect:../list.htm");
            productDAO.save(product);
        }
        
        System.out.println(product);
        return model;
    }

    private void addProductCategoryToModel(ModelAndView model) {
        Iterable<ProductCategory> categories = productCategoryDAO.findAllOrdered();
        model.addObject("categories", categories);
    }
    
}

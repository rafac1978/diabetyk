/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.diabetyk.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.diabetyk.web.dao.ProductCategoryDAO;
import pl.com.softproject.diabetyk.web.dao.ProductDAO;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;
import pl.com.softproject.diabetyk.web.model.UserData;
import pl.com.softproject.diabetyk.web.services.ProductService;
import pl.com.softproject.diabetyk.web.services.UserService;

/**
 *
 * @author Adrian Lapierre
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;

    private Map<String, ProductCategory> productCategoryCache = new HashMap<String, ProductCategory>();
    
    @PostConstruct
    private void initCache() {
        logger.debug("initializing cache");
        
        Iterable<ProductCategory> tmp = productService.findAllCategories();
        for(ProductCategory cat : tmp) {
            productCategoryCache.put(String.valueOf(cat.getId()), cat);
        }
    }
    
    @RequestMapping("/test")
    public String test() {

        return "redirect:../list.htm";

    }

    @RequestMapping("/add")
    public ModelAndView addProduct() {

        ModelAndView model = new ModelAndView("add-product");
        model.addObject("product", new Product());
        addProductCategoryToModel(model);

        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView saveProduct(@Valid Product product, BindingResult bindingResult) {

        System.out.println("cat: " + product.getCategories());
        
        ModelAndView model = new ModelAndView();

        if (bindingResult.hasErrors()) {
            model.setViewName("add-product");
            addProductCategoryToModel(model);
        } else {
            model.setViewName("redirect:../list");
            UserData currentUser = userService.loadCurrentUserData();
            product.setAuthor(currentUser);
            productService.saveProduct(product);
        }

        logger.debug(product);
        return model;
    }

    private void addProductCategoryToModel(ModelAndView model) {
        Iterable<ProductCategory> categories = productService.findAllCategoriesOrdered();
        model.addObject("categories", categories);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Set.class, "categories", new CustomCollectionEditor(Set.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof ProductCategory) {
                    logger.debug("Converting from Staff to Staff: " + element);
                    return element;
                }
                if (element instanceof String) {
                    ProductCategory staff = productCategoryCache.get((String)element);
                    logger.debug("Looking up staff for id " + element + ": " + staff);
                    return staff;
                }
                if (element instanceof Long) {
                    ProductCategory staff = productCategoryCache.get(((Long)element).toString());
                    logger.debug("Looking up staff for long id " + element + ": " + staff);
                    return staff;
                }
                logger.debug("Don't know what to do with: " + element + ": " + element.getClass());
                return null;
            }
        });
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.diabetyk.web.dto.UserDTO;
import pl.com.softproject.diabetyk.web.model.UserData;
import pl.com.softproject.diabetyk.web.services.UserService;

/**
 *
 * @author Adrian Lapierre
 */
@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
    
    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        
        model.addAttribute("user", new UserDTO());
        
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@Valid UserDTO user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        
        if(bindingResult.hasErrors()) {
            
            System.out.println(bindingResult);
            
            model.setViewName("register");
            return model;
        } else {        
            userService.registerUser(user.getUserName(), user.getPassword(), user.getEmail());
            model.setViewName("redirect:/home");
            return model;
        }
        
    }
    
}

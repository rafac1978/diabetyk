/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.services;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import pl.com.softproject.diabetyk.web.model.UserData;

/**
 *
 * @author Adrian Lapierre
 */
@ContextConfiguration({"/diabetyk-web-core.xml"})
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    
//    @Autowired
//    UserService userService;
//    
    /**
     * Test of registerUser method, of class UserServiceImpl.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        
        //userService.registerUser("adrian", "alamakota", "adrian@soft-project.pl");
        
    }

    /**
     * Test of makeModerator method, of class UserServiceImpl.
     */
    @Test
    public void testMakeModerator() {
        System.out.println("makeModerator");
        String username = "";
        UserServiceImpl instance = new UserServiceImpl();
        instance.makeModerator(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeAdmin method, of class UserServiceImpl.
     */
    @Test
    public void testMakeAdmin() {
        System.out.println("makeAdmin");
        String username = "";
        UserServiceImpl instance = new UserServiceImpl();
        instance.makeAdmin(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordReset method, of class UserServiceImpl.
     */
    @Test
    public void testPasswordReset() {
        System.out.println("passwordReset");
        String username = "";
        UserServiceImpl instance = new UserServiceImpl();
        instance.passwordReset(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class UserServiceImpl.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPassword = "";
        String newPassword = "";
        UserServiceImpl instance = new UserServiceImpl();
        instance.changePassword(oldPassword, newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserDetailsManager method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserDetailsManager() {
        System.out.println("getUserDetailsManager");
        UserServiceImpl instance = new UserServiceImpl();
        UserDetailsManager expResult = null;
        UserDetailsManager result = instance.getUserDetailsManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserDetailsManager method, of class UserServiceImpl.
     */
    @Test
    public void testSetUserDetailsManager() {
        System.out.println("setUserDetailsManager");
        UserDetailsManager userDetailsManager = null;
        UserServiceImpl instance = new UserServiceImpl();
        instance.setUserDetailsManager(userDetailsManager);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCurrentUserData method, of class UserServiceImpl.
     */
    @Test
    public void testLoadCurrentUserData() {
        System.out.println("loadCurrentUserData");
        UserServiceImpl instance = new UserServiceImpl();
        UserData expResult = null;
        UserData result = instance.loadCurrentUserData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

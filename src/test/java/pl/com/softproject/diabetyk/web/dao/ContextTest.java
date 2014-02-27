/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.dao;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *
 * @author Adrian Lapierre
 */
@ContextConfiguration("/diabetyk-web-core.xml")
public class ContextTest extends AbstractJUnit4SpringContextTests {
    
    @Test
    public void testContext() {
        System.out.println("test");
    }
    
    
}

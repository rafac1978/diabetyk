/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.dao;

import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author Adrian Lapierre
 */
public class TestTest {
    
    @Test
    public void test() {
        
        String str = "diabetyk-web/product/add.htm";
        String arr[] = str.split("/", 2);
        
        System.out.println(Arrays.toString(arr));
        
    }
    
}

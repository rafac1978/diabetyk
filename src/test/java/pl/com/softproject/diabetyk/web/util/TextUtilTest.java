/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.diabetyk.web.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TextUtilTest {
    
    /**
     * Test of createFileNameFromString method, of class TextUtil.
     */
    @Test
    public void testCreateFileNameFromString() {
        System.out.println("createFileNameFromString");
        String string = "ąśćźżńłóę";
        String expResult = "asczznloe";
        
        String result = TextUtil.stripAccentsAndNonASCII(string);
        System.out.println(string);
        System.out.println(result);
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void replaceWhiteCharsTest() {
        
        System.out.println("createFileNameFromString");
        String string = "ala ma kota";
        String expResult = "ala-ma-kota";
        String res = TextUtil.replaceWhiteChars(string, "-");
        
        System.out.println(res);
        System.out.println(string);
        
        Assert.assertEquals(expResult, res);
        
    }
    
}

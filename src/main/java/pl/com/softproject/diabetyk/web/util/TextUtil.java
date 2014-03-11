/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.diabetyk.web.util;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TextUtil {
    
    private static final Map<Character, String> NONDIACRITICS = new HashMap<Character, String>();
    
    static {
        NONDIACRITICS.put('ł', "l");
        NONDIACRITICS.put('Ł', "L");
    }
    
    public static String stripAccentsAndNonASCII(String string) {
    
        String convertedString = StringUtils.stripAccents(string);
        
        //String convertedString = Normalizer.normalize(string, Normalizer.Form.NFKD);
           //.replaceAll("[^\\p{ASCII}]", "");
        
        return removeNonAsci(stripNonDiacritics(convertedString)).toLowerCase();
        
    }
    
    public static String removeNonAsci(String source) {
        return source.replaceAll("[^\\p{ASCII}]", "");
    }
    
    public static String replaceWhiteChars(String source, String replacment) {
        return source.replaceAll("\\s", replacment);
    }
    
    private static String stripNonDiacritics(String orig) {
        StringBuilder ret = new StringBuilder();
        String lastchar = null;
        for (int i = 0; i < orig.length(); i++) {
            char source = orig.charAt(i);
            String replace = NONDIACRITICS.get(source);
            String toReplace = replace == null ? String.valueOf(source) : replace;
            
            ret.append(toReplace);
        }
        
        return ret.toString();
    }
    
}

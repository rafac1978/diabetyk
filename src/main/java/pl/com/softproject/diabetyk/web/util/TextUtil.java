/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
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

        return removeNonAscii(stripNonDiacritics(convertedString)).toLowerCase();
    }

    public static String removeNonAscii(String source) {
        return source.replaceAll("[^\\p{ASCII}]", "");
    }

    public static String replaceWhiteChars(String source, String replacement) {
        return source.replaceAll("\\s", replacement);
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

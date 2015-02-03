package by.hrodna.pzakh.palindrome;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by PZakharau on 2/3/2015.
 */
public class Execute {
    static final Log log = LogFactory.getLog(Execute.class);
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1) {
            log.error("Proper Usage is: <Number for palindrome>");
            System.exit(0);
        }
        if (!isInteger(args[0])) {
            log.error("Input string is not type of int");
            System.exit(0);
        }
        Palindrome palindromeObject = new Palindrome(Integer.valueOf(args[0]));
        palindromeObject.getResult();
    }
}

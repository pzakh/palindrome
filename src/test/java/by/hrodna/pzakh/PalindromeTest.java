package by.hrodna.pzakh;

import by.hrodna.pzakh.palindrome.Palindrome;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by PZakharau on 2/3/2015.
 */
public class PalindromeTest {
    @Test
    public void calculate(){
        Palindrome palindromeObject = new Palindrome(2);
        String actual = palindromeObject.getResult();
        int expected = 9009;
        assertEquals("adding 9009", expected, actual);
    }
}

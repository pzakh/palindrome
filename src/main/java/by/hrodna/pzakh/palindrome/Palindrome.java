package by.hrodna.pzakh.palindrome;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigInteger;

/**
 * Created by PZakharau on 2/3/2015.
 */
public class Palindrome {
    static final Log log = LogFactory.getLog(Palindrome.class);

    public String getResult(int n) {
        long startTime = System.nanoTime();
        String result = findMax(n);
        long stopTime = System.nanoTime() - startTime;
        log.info(stopTime / 1e9 + " time working in seconds");
        return result;
    }

    private String findMax(int n) {
        int maxNumber = (int) Math.pow(10, n) - 1;
        String multiplyToString = null;
        for (int i = maxNumber; i > 0; i--) {
            BigInteger multiplyResult = BigInteger.valueOf(maxNumber).multiply(BigInteger.valueOf(i));
            int multiplyLength = String.valueOf(multiplyResult).length();
            multiplyToString = String.valueOf(multiplyResult);
            int k = 0, count = 0;
            for (; k < multiplyLength / 2; k++)
                if (multiplyToString.charAt(k) == multiplyToString.charAt(multiplyLength - k - 1))
                    count++;
            if (count == k) {
                if (multiplyToString.equals(new StringBuilder(multiplyToString).reverse().toString())) {
                    log.info("For n = " + n + " calculated result " + multiplyToString + "(" + maxNumber + " * " + i + " = " + multiplyResult + ")");
                } else {
                    log.info("Palindrome is not found ");
                }
                break;
            }
        }
        return multiplyToString;
    }
}

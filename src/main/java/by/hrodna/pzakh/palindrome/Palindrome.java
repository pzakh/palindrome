package by.hrodna.pzakh.palindrome;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by PZakharau on 2/3/2015.
 */
public class Palindrome {
    static final Log log = LogFactory.getLog(Palindrome.class);

    public long getResult(int n) {
        long startTime = System.nanoTime();
        long result = findMax(n);
        long stopTime = System.nanoTime() - startTime;
        log.info(stopTime / 1e9 + " time working in seconds");
        return result;
    }

    private long findMax(int n) {
        long maxNumber = (int) Math.pow(10, n) - 1;
        long palindromeResult = 1;
        long[] arr = new long[(int) maxNumber];
        long multiplyResult = maxNumber * maxNumber;
        for (long firstFactor = maxNumber; firstFactor >= 1; firstFactor--) {
            long actualResult = maxNumber * firstFactor;
            long maxFactorIn = 0;
            long factorIn1 = 0;
            long factorIn2 = 0;
            if (checkPalindrome(actualResult)) {
                palindromeResult = actualResult;
                log.info(maxNumber + " * " + firstFactor + " = " + maxNumber * firstFactor);
                return palindromeResult;
            }
            if (actualResult < multiplyResult) {
                for (long secondFactor = maxNumber; secondFactor >= firstFactor; secondFactor--) {
                    if (arr[((int) (secondFactor - 1))] == 0) {
                        arr[((int) secondFactor - 1)] = secondFactor;
                    }
                    long factorNumber2 = arr[((int) secondFactor - 1)];
                    long actualResult2 = secondFactor * factorNumber2;
                    if (checkPalindrome(actualResult2)) {
                        palindromeResult = actualResult2;
                        log.info(secondFactor + " * " + factorNumber2 + " = " + secondFactor * factorNumber2);
                        return palindromeResult;
                    }
                    if (actualResult2 < multiplyResult) {
                        if (maxFactorIn < actualResult2) {
                            maxFactorIn = actualResult2;
                            factorIn1 = secondFactor;
                            factorIn2 = factorNumber2;
                        }
                    } else {
                        arr[((int) (secondFactor - 1))] = --factorNumber2;
                        secondFactor++;
                    }
                }
                if (actualResult > maxFactorIn) {
                    multiplyResult = actualResult;
                } else {
                    multiplyResult = maxFactorIn;
                    arr[((int) (factorIn1 - 1))] = factorIn2 - 1;
                    firstFactor++;
                }
            } else {
            }
        }
        return palindromeResult;
    }

    private boolean checkPalindrome(long a) {
        String palindromeString = Long.toString(a);
        String reverseString = String.valueOf(new StringBuilder(palindromeString).reverse());
        if (palindromeString.equals(reverseString))
            return true;
        else
            return false;
    }
}

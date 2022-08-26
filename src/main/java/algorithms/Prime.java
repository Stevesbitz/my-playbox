package algorithms;

import org.apache.commons.codec.binary.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public static void main(String[] args) {
//        System.out.println(isPrime(4));
//        System.out.println(isPrime(1));


         for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    static boolean isPrime(int n) {
        if (n < 1) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

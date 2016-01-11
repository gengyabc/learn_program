package geng.charpter1.body;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by yu on 2016-1-11.
 */
public class Factors {
    public Factors(long num) {
        for (long i = 2; i <= num / i; i++) {
            while ( num % i == 0) {
                num /= i;
                System.out.print(i + " ");
            }
        }
        if (num > 1) System.out.print(num);
    }
}

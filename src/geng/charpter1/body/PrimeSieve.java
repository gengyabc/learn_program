package geng.charpter1.body;

/**
 * Print out the primes less than n
 */
public class PrimeSieve {

    private boolean[] isPrime;
    private int numPrimes;

    public PrimeSieve(int n) {
        isPrime = new boolean[n+1];

        // even numbers (except 2) are false, odd numbers are true
        for(int i = 2; i <= n; i++) {
            if (i % 2 != 0) {
                numPrimes ++;
                isPrime[i] = true;
            }
        }
        numPrimes ++;  // for 2

        // only calculate odd numbers
        /* this method is not as good as it in the book
        for(int i = 3; i <= n; i += 2) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= n; j +=2) {
                    if (j % i == 0) {
                        if(isPrime[j] == true) {
                            numPrimes --;
                            isPrime[j] = false;
                        }
                    }
                }
            }
        }
        System.out.println(numPrimes);
        System.out.println(2);
        for(int i = 2; i <= n; i++) {
            if (isPrime[i] == true) System.out.println(i);
        }
        */

        // in the book
        numPrimes = 1;
        for(int i = 3; i <= n / i; i +=2) {
            for (int j = i; j <= n / i; j +=2) {
                isPrime[i * j] = false;
            }
        }

        for(int i = 3; i <= n; i += 2) {
            if(isPrime[i] == true) numPrimes ++;
        }
        System.out.print(numPrimes);





    }
}

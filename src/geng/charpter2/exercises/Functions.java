package geng.charpter2.exercises;

/**
 * Created by yu on 2016-1-28.
 */
public class Functions {

    /**
     * Euler's totient function, print out the relative primes with n
     * @param n the integer input
     */
    public static void totient(int n)
    {
        boolean nums[] = new boolean[n+1];
        int total = n - 2;

        // initialize nums[] to make it all true
        for (int i = 2; i < n; i++) {
            nums[i] = true;
        }

        // By division
        for (int i = 2; i <= n - 2; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0 && n % j == 0) {
                    nums[i] = false;
                    total --;
                    break;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (nums[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(total);


    }
}

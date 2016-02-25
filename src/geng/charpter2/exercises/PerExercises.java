package geng.charpter2.exercises;

import geng.StdDraw;
import geng.charpter2.body.Percolation;

/**
 * Created by yu on 2016-2-23.
 */
public class PerExercises {

    /**
     * Draw the reletive prime matrix
     * @param N size
     */
    public static void reletivePrime(int N)
    {
        boolean a[][] = new boolean[N][N];
        for (int i = 2; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if( i != j && !(i % 2 == 0 && j % 2 == 0)) a[i][j] = true;
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = 3; k < N; k++) {
                    if (i % k == 0 && j % k == 0) {
                        a[i][j] = false;
                        a[j][i] = false;
                    }
                }
            }
        }

        printBooleanArray(a);
        Percolation.show(a, true);
    }

    public static void hadamard(int k) {
        int N = (int)Math.pow(2, k);
        boolean H[][] = new boolean[N][N];
        H[0][0] = true;
        for (int n = 1; n < N; n += n)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    H[i + n][j] = H[i][j];
                    H[i][j + n] = H[i][j];
                    H[i + n][j + n] = !H[i][j];
                }

        printBooleanArray(H);
    }

    private static void printBooleanArray(boolean[][] a) {
        for(int i = 0; i < a.length; i ++) {
            for(int j = 0; j < a[0].length; j ++) {
                if (a[i][j]) System.out.print(Integer.toString(i)
                        + Integer.toString(j) +" " );
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}

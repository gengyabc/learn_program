package geng.charpter2.body;

import geng.StdDraw;
import geng.StdOut;
import geng.StdRandom;

/**
 * Created by yu on 2016-2-1.
 */
public class Recursion {

    public static long factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    public static double lnFac(int n)
    {
        if ( n == 1) return 0;
        else return Math.log10(n) + lnFac(n -1);
    }

    public static int EuclidGcd(int larger, int smaller)
    {
        if (smaller == 0) return larger;
        else return EuclidGcd(smaller, larger % smaller);
    }

    public static void BeckettMove(int n, boolean enter)
    {
        if (n == 0) return;
        BeckettMove(n-1, true);
        if (enter) StdOut.println("enter " + n);
        else StdOut.println("exit " + n);
        BeckettMove(n-1, false);
    }

    public static void Hanoi(int n, boolean left)
    {
        if ( n == 0) return;
        Hanoi(n-1, !left);
        if (left) System.out.println(n + " moves to left");
        else System.out.println(n + " moves to right");
        Hanoi(n-1, !left);
    }

    public static void HTree(int n, double lineLength, double centerX, double centerY)
    {
        if (n == 0) return;
        double x0 = centerX - lineLength / 2, x1 = centerX + lineLength / 2;
        double y0 = centerY - lineLength / 2, y1 = centerY + lineLength / 2;
        StdDraw.line(x0, centerY, x1, centerY);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        HTree(n - 1, lineLength / 2, x0, y1);
        HTree(n - 1, lineLength / 2, x0, y0);
        HTree(n - 1, lineLength / 2, x1, y0);
        HTree(n - 1, lineLength / 2, x1, y1);
    }

    public static void Brownian(double x0, double y0,
                                double x1, double y1,
                                double var, double s)
    {
        if (x1 - x0 < 0.01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double delta = StdRandom.gaussian(0, Math.sqrt(var));
        Brownian(x0, y0, xm, ym+delta, var/s, s);
        Brownian(xm, ym + delta, x1, y1, var/s, s);
    }

    public static int Fib(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fib(n-1) + Fib(n-2);
    }

    // everyone will be the first
    // everyone in the substring will be the first
    // prefix are those that already are the first, s are those will to be the first
    public static void perm1(String s) { perm1("", s);}
    public static void perm1(String prefix, String s)
    {
        int N = s.length();
        if (N == 0) StdOut.println(prefix);
        else {
            for (int i = 0; i < N; i++) {
                perm1(prefix + s.charAt(i),
                        s.substring(0, i) + s.substring(i+1, N));
            }
        }
//        it is ok if so
//        String s = "s";
//        s.substring(1,1);
    }

    // Everyone will be the last
    // 17
    public static void perm2(String s) {
        int N = s.length();
        char a[] = new char[N];
        for (int i = 0; i < N; i++) {
            a[i] = s.charAt(i);
        }
        perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            for ( char c : a) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    private static void swap(char a[], int i, int j) {
        char c= a[i];
        a[i] = a[j];
        a[j] = c;
    }

    // bullets will be everywhere
    public static void perm3(String bullets) { perm3(bullets, "");}
    public static void perm3(String bullets, String s)
    {
        int N = bullets.length();
        int n = s.length();
        if (N == 0) {
            StdOut.println(s);
        }
        else {
            for (int i = 0; i <= n; i++) {
                perm3(bullets.substring(0, N - 1),
                        s.substring(0, i) + bullets.charAt(N - 1) + s.substring(i, n));
            }
        }
    }

    // 18
    public static void permK(String s, int n, int k)
    {
        selectFrom(s.substring(0, n),"", 0, k);
    }

    /**
     * Select k items form s, begin from index of b
     * @param s The source string
     * @param result The selected result
     * @param b Selection begin from index of b
     * @param k The number of chars to select
     */
    private static void selectFrom(String s,String result, int b, int k)
    {
        if (k == 0) {
            perm2(result);
            return;
        }
        int N = s.length() - k;
        for (int i = b; i <= N; i++) {
            selectFrom(s, s.charAt(i) + result, i + 1, k -1);
        }
    }

    public static void choose(char a[], int R)
    {
        enumerate(a, a.length, R);
    }

    private static void enumerate(char[] a, int n, int r) {
        if (r == 0) {
            for (int i = n; i < a.length; i++)
                StdOut.print(a[i]);
            StdOut.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, r - 1);
            swap(a, i, n - 1);
        }
    }

    public static void combination(String source) { combination("", source);}
    private static void combination(String prefix, String source)
    {
        if (source.length() == 0) return;
        else {
            StdOut.println(prefix + source.charAt(0));
            combination(prefix + source.charAt(0), source.substring(1));
            combination(prefix, source.substring(1));
        }
    }

    public static void comb2(String s) { comb2("", s);}
    private static void comb2(String prefix, String s) {
        StdOut.println(prefix);
        for (int i = 0; i < s.length(); i++) {
            comb2(prefix + s.charAt(i), s.substring(i + 1));
        }
    }
}

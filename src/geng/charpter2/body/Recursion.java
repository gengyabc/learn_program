package geng.charpter2.body;

import geng.StdDraw;
import geng.StdOut;
import geng.StdRandom;

/**
 * Created by yu on 2016-2-1.
 */
public class Recursion {

    public static long factorial(int n) {
        if ( n == 1) return 1;
        else return n * factorial(n - 1);
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
}

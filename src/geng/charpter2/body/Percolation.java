package geng.charpter2.body;

import geng.StdArrayIO;
import geng.StdDraw;
import geng.StdOut;
import geng.StdRandom;

/**
 * Created by yu on 2016-2-19.
 */
public class Percolation {
    // for vertical only
//    public static boolean[][] flow(boolean[] [] open)
//    {
//        int N = open.length;
//        boolean[][] full = new boolean[N][N];
//        for (int j = 0; j < N; j++) {
//            full[0][j] = open[0][j];
//        }
//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                full[i][j] = open[i][j] && full[i - 1][j];
//            }
//        }
//        return full;
//    }

    public static boolean[][] flow(boolean open[][])
    {
        // Fill every site reachable from the top row
        int N = open.length;
        boolean full[][] = new boolean[N][N];
        for (int i = 0; i < N; i++)
            flow(open, full, 0,i);
        return full;

    }

    /**
     * Fill every site reachable from (i, j)
     * @param open open array
     * @param full array needed to be fulled
     * @param i current i
     * @param j current j
     */
    private static void flow(boolean[][] open, boolean[][] full, int i, int j) {
        // Fill every site reachable from (i,j)
        int N = full.length;
        if (i < 0 || i >= N) return;
        if (j < 0 || j >= N) return;
        if (!open[i][j]) return;
        if (full[i][j]) return;
        full[i][j] = true;
        flow(open, full, i + 1, j);
        flow(open, full, i, j + 1);
        flow(open, full, i, j - 1);
        flow(open, full, i - 1, j);

    }

    public static void show(boolean[][] a, boolean which)
    {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, N-i-1, 0.5);
    }

    public static boolean[][] random(int N, double p)
    {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }
    public static boolean percolates(boolean[][] open)
    {
        boolean[][] full = flow(open);
        int N = full.length;
        for (int j = 0; j < N; j++)
            if (full[N-1][j]) return true;
        return false;
    }


    /**
     * Visulize the percolation
     * @param N System size n-by-n
     * @param p site vacancy probability
     * @param t number of trials
     */
    public static void visualize(int N, double p, int t) {
        boolean[][] open = random(N, p);
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        show(open, false);
        StdDraw.setPenColor(StdDraw.BLUE);
        boolean[][] full = flow(open);
        show(full, true);
        StdDraw.show(1000);
    }

    /**
     * Estimate the probalility of percolation
     * @param N size N by N
     * @param p site vacancy probability
     * @param T number of trials
     * @return percalation probability
     */
    public static double eval(int N, double p, int T)
    {
        int cnt = 0;
        for (int t = 0; t < T; t++) {
            boolean open[][] = random(N, p);
            if (percolates(open)) cnt ++;
        }
//        StdOut.println((double) cnt / T);
        return (double) cnt / T;
    }

    /**
     * Perform experiments and plot results
     * @param N system size
     * @param x0 left endpoint
     * @param y0 left endpoint
     * @param x1 right endpoint
     * @param y1 right endpoint
     */
    public static void curve(int N, double x0, double y0,double x1, double y1)
    {
        // gap tolerance
        double gap = 0.005;
        // error tolerance
        double err = 0.05;
        // number of trials
        int T = 10000;
        // midpoint
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = eval(N, xm, T);
        if (x1 - x0 < gap && Math.abs(ym - fxm) < err)
        {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(N, x0, y0, xm, fxm);
        StdDraw.filledCircle(xm, fxm, 0.005);
        curve(N, xm, fxm, x1, y1);
    }

    public static void main(String[] args)
    {
        boolean[][] open = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(open));
        StdOut.println(percolates(open));
        show(open,true);
    }
}

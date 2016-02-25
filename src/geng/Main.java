package geng;

import geng.charpter1.exercises.ArrayExercises;
import geng.charpter2.body.Gaussian;
import geng.charpter2.body.Percolation;
import geng.charpter2.body.Recursion;
import geng.charpter2.exercises.PerExercises;

import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) {


        // Flip coins
//        Flip flip = new Flip(100);

        // Harmonic
//        Harmonic harmonic = new Harmonic(10);

        // Square root
//        SquareRoot squareRoot = new SquareRoot(2, 2);

        // Gambler
//        Gambler gambler = new Gambler(1,0,10,100);

        // Factors
//        Factors factors = new Factors(3757208);

//        Cards cards = new Cards();
//        cards.couponCollector(5);

//        PrimeSieve primeSieve = new PrimeSieve(100);

//        SelfAvoidingWalk selfAvoidingWalk = new SelfAvoidingWalk(20, 100);
//        selfAvoidingWalk.walkOut();

//        ArrayExercises a = new ArrayExercises();
//        a.oneD();
//        a.putWhat(10);
//        a.copy2DArray();
//        a.tranposition();
//        a.relativePrime(8, 10);
//        a.booleanArrayProduct();
//        a.dice(10);
//        a.longestPlateau();
//        a.hadamardMatrix(3);
//        a.rumorPropagation(100);
//        a.findDuplicates(10);
//        a.mineSweeper(5,5, 0.5);
//        a.lengthOfSelfAvoid(100);
//        a.randomWalkers(10);

//        Rotation rotation = new Rotation(5);

//        Surfer surfer = new Surfer(100000);
//        Markov markov = new Markov(20);

//        double z = 820;
//        double mu = 1019;
//        double sigma = 209;
//        StdOut.printf("%.3f\n", Gaussian.Phi((z - mu) / sigma));

//        Functions.totient(20);

//        Triangle triangle = new Triangle();
//        int n = 50;
//        double a[] = new double[n+1];
//        for (int i = 0; i <= n; i++) {
//            a[i] = Gaussian.phi(-4.0 + 8.0 * i / n);
//        }
//        StdStats.plotPoints(a);
//        StdStats.plotLines(a);

//        long result = Recursion.factorial(5);
//        double result = Recursion.lnFac(5);
//        int result = Recursion.EuclidGcd(2342, 88);
//        System.out.println(result);

//        Recursion.Hanoi(4, true);
//        Recursion.BeckettMove(4, true);
//        Recursion.HTree(5, 0.5, 0.5, 0.5);
//        Recursion.Brownian(0, 0.5, 1, 0.5, 0.01, Math.pow(2, 2*0.05));

//        int N = 3;
//        String alphabet = "abcdefghijklmnopq";
//        String elements = alphabet.substring(0, N);
//        Recursion.perm2(elements);
//        Recursion.permK(alphabet,4, 2);
//        Recursion.combination(elements);
//        Recursion.comb2(elements);
//        Percolation.visualize(20, 0.9, 1);
//        Percolation.eval(20, 0.85, 1000);
//        Percolation.visualize(20, 0.55, 1);
//        Percolation.curve(20, 0,0,1,1);
//        PerExercises.reletivePrime(10);
        PerExercises.hadamard(2);


    }
}

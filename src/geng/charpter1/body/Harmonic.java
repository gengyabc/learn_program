package geng.charpter1.body;

/**
 * Harmoic
 */
public class Harmonic {
    public Harmonic(int num) {
        double total = 0;
        for(double i = 1; i <= num; i ++) {
            total += 1/i;
        }
        System.out.print(total);
    }
}

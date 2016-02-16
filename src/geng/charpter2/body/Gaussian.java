package geng.charpter2.body;

/**
 * Created by yu on 2016-1-28.
 */
public class Gaussian {
    // Implement Gaussian distribution function
    public static double phi(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double Phi(double z)
    {
        if (z < -8.0) return 0;
        if (z > 8.0) return 1.0;
        double sum = 0.0, term = z;

        for (int i = 3; sum != sum + term; i += 2) {
            sum = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + phi(z) * sum;
    }

}

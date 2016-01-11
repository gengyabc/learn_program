package geng.charpter1.body;

/**
 * Square root using Newton's method
 */
public class SquareRoot {
    public SquareRoot(double arguement, double estimate, double tolerance) {
        while(Math.abs(estimate * estimate - arguement) > tolerance) {
            estimate = (estimate + arguement / estimate) /2;
        }
        System.out.println("Square root of " + arguement + " is " + estimate);
    }

    public SquareRoot(double argument, double estimate) {
        this(argument, estimate, 1e-5);
    }
}

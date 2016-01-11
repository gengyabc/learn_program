package geng.charpter1.body;

/**
 * Flipping fair coin use for loop
 */
public class Flip {
    int num = 0;

    public Flip(int total) {
        for(int i = 0; i < total; i++) {
            double random = Math.random();
            if (random < 0.5) {
                System.out.print("Head" + " ");
                num ++;
            } else {
                System.out.print("Tail" + " ");
            }
        }
        System.out.println();
        System.out.print( 100 * num / total +
        "% are heads");
    }
}

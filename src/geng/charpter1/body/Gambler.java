package geng.charpter1.body;

/**
 * Created by yu on 2016-1-11.
 */
public class Gambler {
    public Gambler(int init, int losePoint, int goal, int totalNum) {
        int ownNum = init;
        int tryNum = 0;
        for(int i = 1; i <= totalNum; i ++) {
            if ( Math.random() < 0.5) ownNum ++;
            else ownNum --;
            if (ownNum <= losePoint) {
                tryNum = i;
                break;
            }
        }
        if (ownNum > 0) System.out.print("You won");
        else System.out.print("After " + tryNum + " rounds, you lose");
    }
}

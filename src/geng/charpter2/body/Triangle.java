package geng.charpter2.body;

import geng.StdDraw;
import geng.StdRandom;

/**
 * Created by yu on 2016-1-29.
 */
public class Triangle {

    public Triangle() {
        double cx[] = { 0, 1, 0.5};
        double cy[] = { 0, 0, 0.866};
        int T = 10000;
        double x= 0, y = 0;

        for (int t = 0; t < T; t++) {
            int r = StdRandom.uniform(3);
            x = (x + cx[r]) / 2;
            y = (y + cy[r]) / 2;
            StdDraw.point(x, y);
        }
    }
}

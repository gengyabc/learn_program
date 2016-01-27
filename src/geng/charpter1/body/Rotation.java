package geng.charpter1.body;

/**
 * Created by yu on 2016-1-26.
 */
public class Rotation {

    public  Rotation(int size) {
        int map[][] = new int[size][size];
        int x = -1;
        int y = 0;

        int loop = -1;
        // 0 down, 1 right, 2 up, 3 left.
        int direction = 0;

        for (int i = 0; i < size * size + 1; i++) {
            if ( x == y && x <= size / 2 && y <= size / 2) {
                loop++;
            }
            if (y <= size / 2 && direction == 0) {
                if (x != size - loop - 1) {
                    x++;
                } else {
                    direction = 1;
                }
            }
            if ( x > size / 2 && direction == 1) {
                if (y != size - loop - 1) {
                    y++;
                } else {
                    direction = 2;
                }
            }
            if (y > size / 2 && direction == 2) {
                if ( x != loop) {
                    x--;
                } else {
                    direction = 3;
                }
            }
            if ( x <= size / 2 && direction == 3) {
                if ( y != loop + 1) {
                    y--;
                } else {
                    direction = 0;
                    x++;
                }
            }
            map[x][y] = i;
        }

        for (int m[] : map) {
            for (int n : m) {
                if ( n < 10) System.out.print("0" + n + " ");
                else System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

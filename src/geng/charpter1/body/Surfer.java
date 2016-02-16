package geng.charpter1.body;

import geng.StdDraw;
import geng.StdOut;

/**
 * Created by yu on 2016-1-26.
 */
public class Surfer {

    int pageNumber;
    // The transition matrix
    double transtionMatrix[][];
    int counts[][];
    int outDegree[];
    double freq[];

    public Surfer(int times) {
        pageNumber = 5;
        transtionMatrix = new double[pageNumber][pageNumber];
        counts = new int[pageNumber][pageNumber];
        outDegree = new int[pageNumber];

        setTransitionMatrix();
//        surf(times);
        surfByVetor(20);
        drawHistogram();
    }

    private void surfByVetor(int T) {
        freq = new double[pageNumber];
        freq[0] = 1;

        for (int i = 0; i < T; i++) {
            double newRank[] = new double[pageNumber];
            for (int j = 0; j < pageNumber; j++) {
                for (int k = 0; k < pageNumber; k++) {
                    newRank[j] += freq[k] * transtionMatrix[k][j];
                }
            }
            for (int j = 0; j < pageNumber; j++) {
                freq[j] = newRank[j];
            }
        }
        for (int i = 0; i < pageNumber; i++) {
            StdOut.printf("%8.5f", freq[i]);
        }
        StdOut.println();

    }

    private void drawHistogram() {
        StdDraw.clear();
        StdDraw.setXscale(-1, pageNumber);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.5 / pageNumber);
        for (int i = 0; i < pageNumber; i++) {
            StdDraw.line(i, 0, i, freq[i]);
        }
        StdDraw.show(20);
    }

    private void surf(int moveNum) {
        int page = 0;
        freq = new double[pageNumber];
        for (int t = 0; t < moveNum; t++) {
            double r = Math.random();
            double sum = 0;
            for (int i = 0; i < pageNumber; i++) {
                sum += transtionMatrix[page][i];
                if ( r < sum ) {
                    page = i;
                    break;
                }
            }
            freq[page]++;
        }
        for (int i = 0; i < pageNumber; i++) {
            StdOut.printf("%8.5f", freq[i] /= moveNum);
        }
    }

    private void setTransitionMatrix() {
        readFromArray();

        StdOut.println(pageNumber + " * " + pageNumber);
        for (int i = 0; i < pageNumber; i++) {
            for (int j = 0; j < pageNumber; j++) {
                transtionMatrix[i][j] = 0.9 * counts[i][j] / outDegree[i] + 0.1 / pageNumber;

                StdOut.printf("%8.5f", transtionMatrix[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();
    }


    private void readFromArray() {
        int source[] = {
                0, 1,
                1, 2, 1, 2,
                1, 3, 1, 3, 1, 4,
                2, 3,
                3, 0,
                4, 0, 4, 2};

        for ( int i = 0; i < source.length; i += 2) {
            outDegree[source[i]]++;
        }
        for (int i = 1; i < source.length; i += 2) {
            counts[source[i-1]][source[i]]++;
        }
    }

}

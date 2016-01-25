package geng.charpter1.exercises;

/**
 * Array excercises of 1.4.x
 */
public class ArrayExercises {

    // 1.4.4
    public void oneD() {
        int a[] = {1,2,3,4,5,6,7};
        int b[] = {1,2,3,4,5,6,7,8};

        printArray(a);
        printArray(b);
        exchangePosition(a);
        exchangePosition(b);
        printArray(a);
        printArray(b);


    }

    private void printArray(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private void exchangePosition(int[] a) {
        int temp;
        int length = a.length;
        for (int i = 0; i < length / 2; i ++) {
            temp = a[i];
            a[i] = a[length - 1 - i];
            a[length - 1 - i] = temp;
        }
    }

    // 1.4.7
    public void printWhat() {
        int[] a = new int[10];
        for (int i =0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(a[i]);
    }

    // 1.4.8
    public void putWhat(int N) {
        int a[] = new int[N];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < N; i ++) {
            a[i] = a[i - 1] + a[i - 2];
            System.out.print(a[i] + " ");
        }
    }

    // 1.4.11
    public void copy2DArray() {
        int a[][] = new int[][]{
                new int[] {1},
                new int[] {1, 2},
                new int[] {1, 2, 3},
                new int[] {1, 2, 3, 4}
        };

        int numRow = a.length;

        int b[][] = new int[numRow][];

        for (int i = 0; i < numRow; i ++) {
            b[i] = new int[a[i].length];
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }

        print2dArray(b);
    }

    // 1.4.12
    public void tranposition() {
        int a[][] = new int[][] {
                new int[] {11, 12, 13},
                new int[] {21, 22, 23},
                new int[] {31, 32, 33}
        };
        int b[][] = new int[3][3];
        for (int i = 0; i < a.length; i ++) {
            for (int j = 0; j < a[0].length; j ++) {
                b[j][i] = a[i][j];
            }
        }
        print2dArray(b);

        // 1.4.13
        for (int i = 0; i < b.length; i ++) {
            for (int j = 0; j < i; j ++) {
                int temp = b[i][j];
                b[i][j] = b[j][i];
                b[j][i] = temp;
            }
        }
        print2dArray(b);

    }

    private void print2dArray(int[][] b) {
        for (int i[] : b) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // 1.4.14 N < M for easy logic
    public void relativePrime(int N, int M) {
        boolean a[][] = new boolean[N][M];
        // if i and j are both even and i = j, it will be false
        for(int i = 1; i < N; i += 1)
            for(int j = 1; j < M; j += 1){
                if (i != j && i != 1 && j != 1) {
                    a[i][j] = true;
                }
            }

        for (int i = 2; i < N; i ++) {
            for (int j = 2; j < i; j ++) {
                int range = Math.min(i, j);
                for (int k = 2; k <= range; k++) {
                    if ((i % k == 0) && (j % k == 0)){
                        a[i][j] = false;
                        a[j][i] = false;
                    }
                }
            }
        }
        for (int i = 2; i < N; i ++) {
            for (int j = N; j < M; j ++) {
                int range = Math.min(i, j);
                for (int k = 2; k <= range; k++) {
                    if ((i % k == 0) && (j % k == 0)){
                        a[i][j] = false;
                    }
                }
            }
        }
        printBooleanArray(a);
    }

    private void printBooleanArray(boolean[][] a) {
        for(int i = 0; i < a.length; i ++) {
            for(int j = 0; j < a[0].length; j ++) {
                if (a[i][j]) System.out.print(Integer.toString(i)
                        + Integer.toString(j) +" " );
                else System.out.print("   ");
            }
            System.out.println();
        }
    }

    // 1.4.15
    public void booleanArrayProduct() {
        boolean a[][] = new boolean[][] {
                new boolean[] {true, true, true},
                new boolean[] {false, false, false},
                new boolean[] {true, true,true}
        };
        boolean b[][] = new boolean[][] {
                new boolean[] {false, false, false},
                new boolean[] {true, true, true},
                new boolean[] {true, true,true}
        };
        boolean c[][] = new boolean[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j ++)
                for (int k = 0; k < 3; k ++) {
                    c[i][j] = (a[i][k] && b[k][j]) || c[i][j];
                }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j ++) {
                System.out.print(c[i][j] + "    ");
            }
            System.out.println();
        }
    }

    // 1.4.20
    public void dice(int N) {
        double [] sum = new double[13];
        for (int n = 1; n <= N; n++) {
            double[] dist = new double[13];
            for (int i = 1; i <= 6; i++)
                for (int j = 1; j <= 6; j++)
                    dist[i+j] += 1.0;
            for (int k = 1; k <= 12; k++) {
                dist[k] /= 36.0;
                sum[k] += dist[k];
            }
        }

        double t = 0;
        for (int k = 1; k <= 12; k++) {
            System.out.println(sum[k] / N );
            t += sum[k];
        }
        System.out.println(t);
    }

    // 1.4.21 longest
    public void longestPlateau() {
        int a[] = {1,2,3,4,5,6,6,6,6,6,5,8,8,8,8,6};
        int b[] = new int[a.length];

        System.out.print(b[0] + " ");
        for (int i = 1; i < b.length; i++) {
            b[i] = a[i] - a[i - 1];
            System.out.print(b[i] + " ");
        }

        int maxPosition = 0;
        int maxLength = 2;

        int preMaxPosition = 0;
        int preMaxLength = 2;

        boolean isFound = false;
        for (int i = 1; i < b.length; i++) {
            if (isFound == false) {
                if (b[i] == 0 && b[i -1] > 0) {
                    preMaxPosition = maxPosition;
                    preMaxLength = maxLength;

                    maxPosition = i - 1;
                    maxLength = 2;
                    isFound = true;
                }
            } else { // isFound == true
                if (b[i] == 0) {
                    maxLength ++;
                } else if (b[i] < 0) {
                    isFound = false;
                    if (maxLength < preMaxLength ) {
                        maxLength = preMaxLength;
                        maxPosition = preMaxPosition;
                    }

                }else if (b[i] > 0) {
                    isFound = false;
                    maxLength = preMaxLength;
                    maxPosition = preMaxPosition;
                }
            }
        }
        System.out.println();
        System.out.println("max position: " + maxPosition);
        System.out.println("max length: " + maxLength);
    }

    /**
     * 1.4.16. Print hadamard matrix of size 2^n
     * @param n size of the matrix is 2^n * 2^n
     */
    public void hadamardMatrix (int n) {
        int N = (int) Math.pow(2, n);
        boolean h[][] = new boolean[N][N];

        if (N == 1) {
            h = hardamard1(h);
        } else {
            h = formByhalf(h);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (h[i][j] == true) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

    }

    private boolean[][] hardamard1(boolean[][] h) {
        h[0][0] = true;
        return h;
    }

    private boolean[][] formByhalf(boolean[][] large) {
        int N = large.length / 2;
        boolean half[][] = new boolean[N][N];

        if (N == 1) {
            half = hardamard1(half);
            large[0][0] = large[0][1] = large[1][0] = half[0][0];
            large[1][1] = !half[0][0];
        } else {
            half = formByhalf(half);
            for (int i = 0; i <= N - 1; i++)
                for (int j = 0; j <= N - 1; j++) {
                    large[i][j] = large[i + N][j] = large[i][j + N]= half[i][j];
                    large[i + N][j + N] = !half[i][j];
                }
        }

        return large;

    }

    // 1.4.27
    // I think this code is not what the question means...
    /**
     * If choose the one heard the rumor, the rumor stops.
     * The rumor will not propagate to Alic or the person
     * @param N guests number include Bob
     */
    public void rumorPropagation(int N) {
        // store the person from whom one heard the rumor
        // 0 means they have not even heard of the rumor
        // non-zero means they have heard of the rumor
        // bob will be hearFrom[1] = 1.
        int hearFrom[] = new int[N + 1];
        hearFrom[0] = 0;
        hearFrom[1] = 1;

        // store if the person has told the rumor to others
        // 0 told to no one
        int peopleToTell[] = new int[N + 1];

        boolean isStop = false;
        // begin propagate
        while (!isStop) {
            // determine how many random choices should made
            // only the one with non-zero element have the change to choose
            int numTell = 0;
            for (int i = 1; i <= N; i++) {
                // know it and did not tell it
                if (hearFrom[i] != 0 && peopleToTell[i] == 0) {
                    numTell ++;
                    int personToTell = 0;
                    do {
                        personToTell = (int) (Math.random() * N) + 1;
                    } while (personToTell == i);
                    // if peopleToTell knows nothing about this
                    if (hearFrom[personToTell] == 0) {
                        hearFrom[personToTell] = i;
                    }
                    peopleToTell[i] = personToTell;
                }
            }
            if (numTell == 0) {
                isStop = true;
                break;
            }
        }

        System.out.println("I here it from:");
        for (int i : hearFrom) {
            System.out.print( i + " ");
        }

        System.out.println();
        System.out.println("I have told to: " );
        for (int i : peopleToTell) {
            System.out.print(i + " " );
        }

    }

    public void findDuplicates(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * n) + 1;
        }

        boolean isDuplicate = false;
        for (int i = 0; i < n; i++)
            if (isDuplicate == false) {
                for (int j = i + 1; j < n; j++){
                    if (a[j] == a[i]) {
                        isDuplicate = true;
                        break;
                    }
                }
            }

        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(isDuplicate);
    }

    /**
     * 1.4.30. Mine sweeper game
     * @param m row num of the array
     * @param n col num of the array
     * @param p probability of the bomb ocupation
     */
    public void mineSweeper(int m, int n, double p)
    {
        if (p <= 0 || p >= 1) p = 0.5;
        boolean mineMap[][] = new boolean[m + 2][n + 2];

        //form the array
        for (int i = 1; i < m + 1; i ++)
            for (int j = 1; j < n + 1; j ++) {
                double r = Math.random();
                if (r < p) mineMap[i][j] = true;
                else mineMap[i][j] = false;
            }

        // print the map
        for (int i = 0; i < m + 2; i ++) {
            for (int j = 0; j < n + 2; j ++) {
                if (mineMap[i][j] == true) System.out.print("*  ");
                else System.out.print(".  ");
            }
            System.out.println();
        }

        // print the numbers
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (mineMap[i][j] == false) {
                    int count = 0;
                    if (mineMap[i][j-1]) count ++;
                    if (mineMap[i][j+1]) count ++;

                    if (mineMap[i-1][j-1]) count ++;
                    if (mineMap[i-1][j]) count ++;
                    if (mineMap[i-1][j+1]) count ++;

                    if (mineMap[i+1][j-1]) count ++;
                    if (mineMap[i+1][j]) count ++;
                    if (mineMap[i+1][j+1]) count ++;
                    System.out.print(count + "  ");
                } else System.out.print("*  ");
            }
            System.out.println();
        }


    }


    // 1.4.31
    public void lengthOfSelfAvoid(int tryNum) {

        int successNum = 0;
        int failNum = 0;
        int totalStepToSuccess = 0;

        int N = 1000;

        for (int i = 0; i < tryNum; i++) {
            boolean twoDGrid[][] = new boolean[N][N];
            // at the center of the grid
            int currentPositionX = N / 2;
            int currentPositionY = N / 2;
            twoDGrid[currentPositionX][currentPositionY] = true;
            int stepNum = 0;

            boolean isOut = false;
            boolean isTrapped = false;

            while(!isTrapped && !isOut) {
                double randomWalk = Math.random();
                twoDGrid[currentPositionX][currentPositionY] = true;

                if (randomWalk < 0.25) {
                    if (!twoDGrid[currentPositionX - 1][currentPositionY]) {
                        currentPositionX --;
                        stepNum ++;
                    }
                } else if (randomWalk < 0.5) {
                    if (!twoDGrid[currentPositionX + 1][currentPositionY]) {
                        currentPositionX ++;
                        stepNum ++;
                    }
                } else if (randomWalk < 0.75) {
                    if (!twoDGrid[currentPositionX][currentPositionY - 1]) {
                        currentPositionY --;
                        stepNum ++;
                    }
                } else if (randomWalk < 1) {
                    if (!twoDGrid[currentPositionX][currentPositionY + 1]) {
                        currentPositionY ++;
                        stepNum ++;
                    }
                }

                if ( currentPositionX == 0 || currentPositionY == 0
                        || currentPositionX == N -1 || currentPositionY == N -1) {
                    isOut = true;
                    successNum ++;
                    totalStepToSuccess += stepNum;
                    break;
                }

                if (twoDGrid[currentPositionX-1][currentPositionY]
                        && twoDGrid[currentPositionX +1][currentPositionY]
                        && twoDGrid[currentPositionX][currentPositionY -1]
                        && twoDGrid[currentPositionX][currentPositionY + 1]) {
                    isTrapped = true;
                    failNum ++;
                    totalStepToSuccess += stepNum;
                }
            }

        }

        System.out.println();
        System.out.println("Success: " + successNum);
        System.out.println("Fail: " + failNum);
        System.out.println("Average steps: " + totalStepToSuccess / tryNum);
    }

    // 1.4.33
    public void randomWalkers(int N)
    {
        boolean twoDGrid[][] = new boolean[N][N];

        int walkerNum = N;

        int totalSteps = 0;

        for (int i = 0; i < walkerNum; i++) {
            boolean walkerPath[][] = new boolean[N][N];
            boolean isOut = false;
            boolean isTrapped = false;

            int currentX = N / 2;
            int currentY = N / 2;
            while(!isOut && !isTrapped) {
                walkerPath[currentX][currentY] = true;
                double randomStep = Math.random();
                if (randomStep < 0.25) {
                    if (!walkerPath[currentX - 1][currentY]) {
                        currentX --;
                        totalSteps ++;
                        twoDGrid = form2DGrid(twoDGrid, currentX, currentY, walkerPath);
                        if (isAllTouched(twoDGrid)) {
                            break;
                        }
                    }
                } else if (randomStep < 0.5) {
                    if (!walkerPath[currentX + 1][currentY]) {
                        currentX ++;
                        totalSteps ++;
                        twoDGrid = form2DGrid(twoDGrid, currentX, currentY, walkerPath);
                        if (isAllTouched(twoDGrid)) {
                            break;
                        }
                    }
                } else if (randomStep < 0.75) {
                    if (!walkerPath[currentX][currentY - 1]) {
                        currentY --;
                        totalSteps ++;
                        twoDGrid = form2DGrid(twoDGrid, currentX, currentY, walkerPath);
                        if (isAllTouched(twoDGrid)) {
                            break;
                        }
                    }
                } else if (randomStep < 1) {
                    if (!walkerPath[currentX][currentY + 1]) {
                        currentY ++;
                        totalSteps ++;
                        twoDGrid = form2DGrid(twoDGrid, currentX, currentY, walkerPath);
                        if (isAllTouched(twoDGrid)) {
                            break;
                        }
                    }
                }

                if (currentX == 0 || currentY == 0
                        || currentX == N - 1 || currentY == N -1) {
                    isOut = true;
                    break;
                }

                if (walkerPath[currentX - 1][currentY] && walkerPath[currentX + 1][currentY]
                        && walkerPath[currentX][currentY - 1] && walkerPath[currentX][currentY + 1]) {
                    isTrapped = true;
                    break;
                }
            }
        }
        System.out.println("total steps: " + totalSteps);
    }

    private boolean[][] form2DGrid(boolean[][] twoDGrid, int currentX, int currentY, boolean[][] walkerPath) {
        twoDGrid[currentX][currentY] = walkerPath[currentX][currentY];
        return twoDGrid;
    }

    private boolean isAllTouched(boolean[][] twoDGrid) {
        for (boolean m[] : twoDGrid) {
            for (boolean n : m) {
                if (!n) return false;
            }
        }
        return true;
    }



}

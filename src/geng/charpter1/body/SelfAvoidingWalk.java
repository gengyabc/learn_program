package geng.charpter1.body;

import geng.Main;

/**
 * The number of trials (tryNum) a dog can get out of
 * a city with dimension of citySize * citySize
 */
public class SelfAvoidingWalk {

    private int mCitySize;
    private int mTryNum;
    private boolean mCity[][];

    private int mInitX;
    private int mInitY;


    public SelfAvoidingWalk(int citySize, int tryNum) {
        mCitySize = citySize;
        mTryNum = tryNum;
    }

    private void initCity() {
        mCity = new boolean[mCitySize][mCitySize];
    }

    public void walkOut() {
        int NumTried;
        int NumSuccess = 0;


        for (NumTried = 0; NumTried < mTryNum; NumTried ++) {
            boolean isOut = false;
            boolean isTrapped = false;
            initCity();
            mInitX = mCitySize / 2;
            mInitY = mCitySize / 2;
            int X = mInitX;
            int Y = mInitY;

            while( !isOut && !isTrapped ) {
                mCity[X][Y] = true;
                double randomPosition = Math.random();
                if (randomPosition < 0.25) {
                    if (!mCity[X-1][Y] ) X --;
                }
                else if (randomPosition < 0.5) {
                    if ( !mCity[X+1][Y] ) X ++;
                }
                else if (randomPosition < 0.75) {
                    if ( !mCity[X][Y+1] ) Y ++;
                }
                else if (randomPosition < 1) {
                    if ( !mCity[X][Y-1] ) Y --;
                }

                if ( X == 0 || X == mCitySize -1 || Y == 0 || Y == mCitySize-1 ) {
                    isOut = true;
                    NumSuccess ++;
                    break;
                }
                if ( mCity[X-1][Y] && mCity[X+1][Y] && mCity[X][Y-1] && mCity[X][Y+1]) {
                    isTrapped = true;
                    break;
                }
            }
        }

        System.out.println(NumSuccess + " out of " + mTryNum + " have successed!");
        System.out.println(100 * NumSuccess / mTryNum + "% success!");
    }
}

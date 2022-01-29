import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        int[] xs = {-2, -3, 4, -5};
        System.out.println(solution(xs));
    }

    public static String solution(int[] xs) {
        BigInteger result = new BigInteger("1");
        int xsLength = xs.length, negCnt = 0, posCnt = 0;
        int[] negIntArr = new int[xsLength];

        if (xsLength == 1) {
            return Integer.toString(xs[0]);
        }

        for (int x : xs) {
            if (x == 0) {
                continue;
            }
            if (x > 0) {
                result = result.multiply(new BigInteger(Integer.toString(x)));
                posCnt++;
            } else {
                negIntArr[negCnt] = x;
                negCnt++;
            }
        }

        if (posCnt == 0) {
            int zero = 0;
            return Integer.toString(zero);
        }

        if ((negCnt % 2) == 0) {
            for (int i = 0; i < negCnt; i++) {
                result = result.multiply(new BigInteger(Integer.toString(negIntArr[i])));
            }
        } else {

            int min = -1000;
            int maxNegID = -1;

            for (int i = 0; i < negCnt; i++) {
                if (negIntArr[i] > min) {
                    min = negIntArr[i];
                    maxNegID = i;
                }
            }
            for (int i = 0; i < negCnt; i++) {
                if (i == maxNegID) {
                    continue;
                }
                result = result.multiply(new BigInteger(Integer.toString(negIntArr[i])));
            }
        }

        return String.valueOf(result);
    }
}

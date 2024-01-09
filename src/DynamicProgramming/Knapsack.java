package DynamicProgramming;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Knapsack {



    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        int[][][] tb = new int[weights.length+1][capacity+1][2];
        for (int i = 0; i < weights.length; i++) {
            tb[0][i] = new int[]{0,0};
            tb[i][0] = new int[]{0,0};
        }

        for (int i = 1; i <= weights.length; i++) {
            int pointer = i - 1;
            for (int j = 1; j <= capacity; j++) {
                int currentWeight = weights[pointer];
                int currentValue = values[pointer];

                int[] prevItemAtWeight = tb[i-1][j];

                if (currentWeight > j) {
                    tb[i][j] = prevItemAtWeight;
                }
                else if (currentWeight == j && prevItemAtWeight[1] < currentValue) {
                    tb[i][j] = new int[]{currentWeight, currentValue};
                }
                else {
                    int weightLeft = j - currentWeight;

                    if (currentValue + tb[i-1][weightLeft][1] > tb[i-1][j][1]) {
                        tb[i][j] = new int[]{currentWeight + tb[i-1][weightLeft][0], currentValue + tb[i-1][weightLeft][1]};
                    }
                    else {
                        tb[i][j] = tb[i-1][j];
                    }
                }
            }
        }

        return tb[weights.length][capacity][1];
    }

    public static int findMaxKnapsackProfit2(int capacity, int [] weights, int [] values) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(values[i] + dp[j - weights[i]], dp[j]);
            }
        }

        return dp[capacity];
    }
}

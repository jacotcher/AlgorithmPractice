package ModifiedBinarySearch;

import java.util.Random;

class RandomPickWithWeight {
    int[] weightSums;

    public RandomPickWithWeight(int[] weights) {
        this.weightSums = new int[weights.length];

        this.weightSums[0] = weights[0];

        for (int i = 1; i < weights.length; i++) {
            weightSums[i] = weights[i] + weightSums[i-1];
        }

    }

    public int pickIndex() {
        Random r = new Random();

        if (this.weightSums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = weightSums[weightSums.length-1];

        int target = r.nextInt(high-low) + low;


        int start = 0;
        int end = weightSums.length;

        while (start < end) {
            int mid = start + (end-start)/2;

            if (weightSums[mid] == target) {
                return mid;
            }
            else if (weightSums[mid] < target) {
                start = mid + 1;
            }
            else if (weightSums[mid] > target) {
                end = mid;
            }
        }

        return end;
    }

    public static int sumW(int[] arr) {
        int sum = 0;
        // Loop through the array to calculate sum of elements
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static float round(float var) {
        float value = (int) (var * 100 + .5);
        return (float) value / 100;
    }
}

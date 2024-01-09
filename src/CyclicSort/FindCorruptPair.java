package CyclicSort;

public class FindCorruptPair {
    public static int[] findCorruptPair(int[] nums) {

        int[] answer = new int[2];

        int i = 0;
        while (i <= nums.length - 1) {

            int toSort = nums[i];
            int newSpot = toSort;

            if (toSort -1 < nums.length && toSort > 0 && toSort - 1 != i) {
                int swapWith = nums[newSpot-1];
                if (swapWith == toSort) {
                    answer[1] = toSort;
                    i++;
                }
                else {
                    nums[newSpot - 1] = toSort;
                    nums[i] = swapWith;

                }
            } else {
                i++;
            }
        }

        for (int j = 0; j< nums.length; j++) {

            if (nums[j]-1 != j) {
                answer[0] = j+1;
                return answer;
            }
        }
        return new int[]{0,0};
    }
}

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchstickToSquare {
    public static boolean matchstickToSquare(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        ArrayList<Integer> top = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> down = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();

        ArrayList<ArrayList<Integer>> square = new ArrayList<>();
        square.add(top);
        square.add(right);
        square.add(down);
        square.add(left);

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        backtrack(nums, 0, square, sum, results);

        return !results.isEmpty();
    }

    public static void backtrack(int[] nums, int pointer, ArrayList<ArrayList<Integer>> square, int sum, ArrayList<ArrayList<Integer>> results) {

        if (pointer >= nums.length) {
            if (isComplete(square)) {
                results.addAll(square);
            }
            return;
        }

        for (ArrayList<Integer> side: square) {
            int sideSum = side.stream().reduce((a,b) -> a+b).orElse(0);

            if (sideSum < sum/4) {
                side.add(nums[pointer]);
                backtrack(nums, pointer + 1, square, sum, results);
                side.remove(side.size() - 1);
            }
        }
    }

    private static boolean isComplete(ArrayList<ArrayList<Integer>> square) {
        int topSum = square.get(0).stream().reduce((a,b) -> a+b).orElse(0);
        int rightSum = square.get(1).stream().reduce((a,b) -> a+b).orElse(0);
        int bottomSum = square.get(2).stream().reduce((a,b) -> a+b).orElse(0);
        int leftSum = square.get(3).stream().reduce((a,b) -> a+b).orElse(0);
        if (topSum == rightSum && rightSum == bottomSum && bottomSum == leftSum) {
            return true;
        }
        return false;
    }
}

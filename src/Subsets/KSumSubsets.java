package Subsets;

import java.util.ArrayList;
import java.util.List;

public class KSumSubsets {
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();

        backtrack(currentSet, results, setOfIntegers, targetSum, 0, 0);

        return results;
    }

    public static void backtrack(List<Integer> currentSet, List<List<Integer>> results, List<Integer> setOfIntegers, int targetSum, int currentIndex, int currentSum) {
        List<Integer> newCurrentSet = new ArrayList<>(currentSet);
        if (currentSum == targetSum) {
            results.add(newCurrentSet);
        }

        if (currentSum < targetSum && currentIndex < setOfIntegers.size()) {
            int nextValue = setOfIntegers.get(currentIndex);
            newCurrentSet.add(nextValue);
            currentSum += nextValue;
            backtrack(newCurrentSet, results, setOfIntegers, targetSum, currentIndex+1, currentSum);
            newCurrentSet.remove(newCurrentSet.size()-1);
            currentSum -= nextValue;
            backtrack(newCurrentSet, results, setOfIntegers, targetSum, currentIndex+1, currentSum);
        }
    }
}

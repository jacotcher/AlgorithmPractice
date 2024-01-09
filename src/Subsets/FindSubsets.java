package Subsets;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {
    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();

        setsList.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            int currentSetSize = setsList.size();
            for(int j = 0; j < currentSetSize; j++) {
                List<Integer> newList = new ArrayList<Integer>(setsList.get(j));
                newList.add(nums[i]);
                setsList.add(newList);
            }
        }

        return setsList;
    }
}

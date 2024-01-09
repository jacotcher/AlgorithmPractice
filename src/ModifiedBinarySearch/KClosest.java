package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KClosest {
    public static List<Integer> findClosestElements(int[] nums, int k, int target) {

       if (nums.length == k) {
           return Arrays.stream(nums).boxed().collect(Collectors.toList());
       } else if(target < nums[0]) {
           List<Integer> result = new ArrayList<>();
           for (int i =0; i < k; i++) {
               result.add(nums[i]);
           }
           return result;
       } else if(target > nums[nums.length-1]) {
           List<Integer> result = new ArrayList<>();
           for (int i = nums.length - k; i < nums.length; i++) {
               result.add(nums[i]);
           }
           return result;
       }


       int closestToTargetIndex = binarySearchClosestValue(nums, target);

       int left = closestToTargetIndex;
       int right = closestToTargetIndex;

       while (right - left != k - 1) {
           if(left == 0) {
               right += 1;
           }

           else if (right == nums.length-1) {
               left -=1;
           }

           else if (Math.abs(nums[left-1] - target) == Math.abs(nums[right+1] - target)) {
               left -= 1;
           }

           else if (Math.abs(nums[left-1] - target) < Math.abs(nums[right+1] - target)) {
               left -= 1;
           }

           else {
               right += 1;
           }
       }

       List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(nums[i]);
        }

        return result;
    }

    private static int binarySearchClosestValue(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;


        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
               return mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }
}

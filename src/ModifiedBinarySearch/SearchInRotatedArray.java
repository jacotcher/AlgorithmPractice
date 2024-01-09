package ModifiedBinarySearch;

import java.util.List;

public class SearchInRotatedArray {
    public static int binarySearchRotated(List<Integer> nums, int target) {

        int start = 0;
        int end = nums.size() - 1;


        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums.get(mid) == target) {
                return mid;
            }

            if (nums.get(mid) >= nums.get(start)) {
                if (target < nums.get(mid) && target >= nums.get(start)){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            else {
                if (target > nums.get(mid) && target <= nums.get(end)){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

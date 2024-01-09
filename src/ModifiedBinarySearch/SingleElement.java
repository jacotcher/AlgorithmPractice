package ModifiedBinarySearch;

public class SingleElement {

//    public static int singleNonDuplicate(int[] nums) {
//
//        int low = 0;
//        int high = nums.length - 1;
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        else if (nums.length == 0) {
//            return -1;
//        }
//
//        while (low < high) {
//            int mid = low + (high-low)/2;
//
//            if (mid > 0 && mid < nums.length - 1) {
//                if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
//                    return nums[mid];
//                }
//            }
//            else if (mid == 0) {
//                if (nums[mid] != nums[mid+1]) {
//                    return nums[mid];
//                }
//            }
//            else if (mid == nums.length - 1) {
//                if (nums[mid] != nums[mid-1]) {
//                    return nums[mid];
//                }
//            }
//
//            if (mid % 2 == 0 && nums[mid] != nums[mid+1]) {
//                high = mid - 1;
//            }
//            else if (mid % 2 == 0 && nums[mid] == nums[mid+1]) {
//                low = mid + 1;
//            }
//            else if (mid % 2 == 1 && nums[mid] != nums[mid-1]) {
//                high = mid - 1;
//            }
//            else if (mid % 2 == 1 && nums[mid] == nums[mid-1]) {
//                low = mid + 1;
//            }
//        }
//
//        return -1;
//    }

    public static int singleNonDuplicate(int[] nums) {

        // initilaize the left and right pointer
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            // if mid is odd, decrement it to make it even
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) mid--;

            // if the elements at mid and mid + 1 are the same, then the single element must appear after the midpoint
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            }
            // otherwise, we must search for the single element before the midpoint
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}

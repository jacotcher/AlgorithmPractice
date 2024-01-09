package ModifiedBinarySearch;

public class BinarySearchRotated2 {
    public static boolean search(int[] arr, int t, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == t) {
                return true;
            }

            if (arr[mid] > arr[low]) {
                if (t <= arr[mid] && t >= arr[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            } else if (arr[mid] < arr[high]) {
                if (arr[mid] <= t && t <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            } else {
                return (search(arr, t, low, mid - 1) || search(arr, t, mid + 1, high));
            }
        }

        return false;

    }
    public static boolean search(int[] arr, int t) {

        int low = 0;
        int high = arr.length - 1;

        return search(arr, t, low, high);
    }

}

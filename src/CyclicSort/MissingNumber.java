package CyclicSort;

public class MissingNumber {

    public static int findMissingNumber(int[] arr) {

        int i = 0;
        while (i < arr.length) {

            int toSort = arr[i];
            int newSpot = toSort;

            if (toSort != arr.length && toSort != arr[newSpot]) {
                int swapWith = arr[newSpot];
                arr[newSpot] = toSort;
                arr[i] = swapWith;
            } else {
                i++;
            }
        }
        for (int j = 0; j< arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return 0;
    }
}

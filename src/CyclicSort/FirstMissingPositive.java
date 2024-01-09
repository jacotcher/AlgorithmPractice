package CyclicSort;

public class FirstMissingPositive {

    public static int firstMissingPositiveInteger(int[] arr) {

        int i = 0;
        while (i <= arr.length - 1) {

            int toSort = arr[i];
            int newSpot = toSort;

            if (toSort -1 < arr.length && toSort > 0 && toSort - 1 != i) {
                int swapWith = arr[newSpot-1];
                arr[newSpot-1] = toSort;
                arr[i] = swapWith;
            } else {
                i++;
            }
        }

        for (int j = 0; j< arr.length; j++) {

            if (arr[j]-1 != j) {
                return j+1;
            }
        }
        return arr.length + 1;
    }
}

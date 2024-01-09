package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {

        ArrayList<Integer> answer = new ArrayList<>();

        int highest = 0;

        int i = 0;

        while (i < arr.length) {

            int currentIndex = i;
            int currentNumber = arr[i];

            if (currentNumber > highest) {
                highest = currentNumber;
            }

            if (currentIndex == currentNumber - 1 || currentNumber <= 0 || currentNumber -1 >= arr.length) {
                i++;
            }
            else {
                int temp = arr[currentNumber-1];
                arr[currentNumber-1] = currentNumber;
                arr[i] = temp;
            }
        }

        for (int j = 0; j < arr.length; j ++) {
           if (arr[j] - 1 != j) {
               if (arr[j] <= 0) {
                   answer.add(j+1);
               }
               if (arr[j] > arr.length) {
                   for (int p = answer.get(answer.size()-1)+1; p < arr[j]; p++) {
                       if (answer.size() < k) {
                        answer.add(p);
                       }
                   }
               }
           }
        }

        if (answer.size() < k) {
            int nextInt = 0;
            if (answer.size() != 0) {
                nextInt = answer.get(answer.size()-1)+1;
            }
            else {
                nextInt = highest;
            }
            int maxNum = nextInt+k-answer.size()-1;

            for (int g = nextInt; g < maxNum; g++) {
                answer.add(g);
            }
        }
        return answer;
    }
}

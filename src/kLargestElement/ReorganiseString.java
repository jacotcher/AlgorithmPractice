package kLargestElement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseString {
    public static String reorganizeString(String string1) {
        HashMap<Character, Integer> map = new HashMap<>();

        StringBuilder output = new StringBuilder();


        for (Character e : string1.toCharArray()) {
            map.merge(e, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(map.entrySet());

        Map.Entry<Character, Integer> prevCharacter = null;

        while (output.length() < string1.length()) {
            if (heap.peek() == null) {
                return "";
            }
            Map.Entry<Character, Integer> next = heap.poll();

            Integer numberLeft = (Integer) next.getValue();
            Character letter = (Character) next.getKey();
            output.append(letter.toString());

            if (prevCharacter != null) {
                heap.add(prevCharacter);
            }

            if (numberLeft > 1) {
                next.setValue(numberLeft - 1);
                map.put(next.getKey(), next.getValue());

                prevCharacter = next;
            } else {
                prevCharacter = null;
            }
        }

        return output.toString();
    }
}


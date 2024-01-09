package Subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombinations {
    public static List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> results = new ArrayList<>();
        letterCombinationsRec(map, new StringBuilder(), digits, results);

        return results;
    }

    public static void letterCombinationsRec(HashMap<Character, String> map, StringBuilder word, String digits, List<String> results) {
        if (word.length() == digits.length()) {
            results.add(word.toString());
            return;
        }
        String potential = map.get(digits.charAt(word.length()));

        for (int k = 0; k < potential.length(); k++) {
            StringBuilder newWord = new StringBuilder(word);
            newWord.append(potential.charAt(k));
            letterCombinationsRec(map, newWord, digits, results);
        }
    }
}

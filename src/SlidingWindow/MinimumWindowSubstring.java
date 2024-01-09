package SlidingWindow;

import java.util.HashMap;
import java.util.Set;

public class MinimumWindowSubstring {
    //    Given two string, s and t, find the minimum window substring in s,
//    which has the following properties:
//    - It is the shorted substring of s that includes all of the characters present in t
//    - It must contain at least the same frequency of each character as in t
//    - The order of the characters does not matter here.
    public static String minWindow(String s, String t) {

        int sStart = 0;
        int sEnd = 0;
        StringBuilder currentString = new StringBuilder();
        HashMap<Character, int[]> charFrequencies = new HashMap<>();
        String currentBestString = "";

        for (char character : t.toCharArray()) {
            charFrequencies.merge(character, new int[]{1, 1}, (a, b) -> increaseMaxCharFreqs(a));
        }

        int numberNeededToComplete = charFrequencies.size();

        while (sStart <= s.length()-1 && sEnd <= s.length()-1) {
            char currentCharacter = s.charAt(sEnd);

            if (charFrequencies.get(currentCharacter) == null) {
                if (windowNotStarted(currentString)) {
                    sStart++;
                    sEnd++;
                }
                else {
                    currentString.append(currentCharacter);
                    sEnd++;
                }

            }
            else {
                if (charFrequencies.get(currentCharacter)[1] > 0) {
                    decrementNumberNeeded(charFrequencies, currentCharacter);
                    currentString.append(currentCharacter);
                    if (charFrequencies.get(currentCharacter)[1] == 0) {
                        numberNeededToComplete--;
                    }
                    sEnd++;
                } else {
                    currentString.append(currentCharacter);
                    sEnd++;
                }
                if (numberNeededToComplete == 0) {
                    if (currentBestString.isEmpty()) {
                        currentBestString = currentString.toString();
                    }
                    else if (currentString.length() < currentBestString.length()) {
                        currentBestString = currentString.toString();
                    }

                    currentString.delete(0, currentString.length());
                    numberNeededToComplete = charFrequencies.size();
                    resetCharFreqs(charFrequencies);
                    sStart++;
                    sEnd = sStart;
                }
                else if (numberNeededToComplete > 0 && sEnd > s.length() - 1) {
                    if (currentBestString.isEmpty()) {
                        return "";
                    }
                    else {
                        currentString.delete(0, currentString.length());
                        numberNeededToComplete = charFrequencies.size();
                        resetCharFreqs(charFrequencies);
                        sStart++;
                        sEnd = sStart;
                    }
                }
            }
        }

        return currentBestString;
    }

    private static boolean windowNotStarted(StringBuilder currentString) {
        return currentString.length() == 0;
    }

    private static void decrementNumberNeeded(HashMap<Character,int[]> charFrequencies, char c) {
        charFrequencies.get(c)[1] = charFrequencies.get(c)[1]-1;
    }

    private static void resetCharFreqs(HashMap<Character,int[]> charFrequencies) {
        Set<Character> keys = charFrequencies.keySet();

        keys.forEach(character -> charFrequencies.get(character)[1] = charFrequencies.get(character)[0]);
    }

    private static int[] increaseMaxCharFreqs(int[] a) {
        a[0] += 1;
        a[1] += 1;
        return a;
    }
}

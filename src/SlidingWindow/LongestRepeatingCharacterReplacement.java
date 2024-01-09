package SlidingWindow;

import java.util.HashMap;

// Given a string, s, of lowercase English characters and an integer, k,
// return the length of the longest substring after replacing at most
// k characters with any other lowercase English character so that all
// the characters in the substring are the same.
public class LongestRepeatingCharacterReplacement {
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        HashMap<Character, Integer> charFreqs = new HashMap<>();
        int start = 0;
        int longestSubstring = 0;
        int mostFreqChar = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentCharacter = s.charAt(end);
            charFreqs.merge(currentCharacter, 1, Integer::sum);

            mostFreqChar = Math.max(mostFreqChar, charFreqs.get(currentCharacter));

            if (end - start - mostFreqChar >= k) {
                char startChar = s.charAt(start);
                charFreqs.put(startChar, charFreqs.get(startChar) - 1);
                start++;
            }

            longestSubstring = Math.max(longestSubstring, end - start + 1);
        }
        return longestSubstring;
    }

}

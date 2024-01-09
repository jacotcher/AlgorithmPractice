package Subsets;

import java.util.ArrayList;

public class PermutationsOfWord {
    public static  void permuteStringRec(String word, int currentIndex, ArrayList<String> results)
    {
        // Prevents adding duplicate permutations
        if(currentIndex == word.length() - 1)
        {
            results.add(word);
            //System.out.println(Arrays.toString(results));
            return ;
        }
        for (int index = currentIndex; index < word.length(); index++)
        {
            // swaps character for each permutation
            String swappedStr = swapChar(word, currentIndex, index);

            // recursively calls itself to find each permutation
            permuteStringRec(swappedStr, currentIndex + 1, results);
        }
    }
    public static ArrayList<String> permuteWord(String word)
    {
        ArrayList<String> results = new ArrayList<String>();
        // Starts finding permuations from start of string
        permuteStringRec(word, 0, results);
        return results;
    }

    private static String swapChar(String word, int i, int j) {
        char[] string = word.toCharArray();
        char temp = string[j];
        string[j] = string[i];
        string[i] = temp;
        return String.valueOf(string);
    }
}

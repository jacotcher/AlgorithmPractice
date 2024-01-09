package Subsets;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParantheses {
    public static ArrayList<String> generateCombinations(int n) {

        StringBuilder string = new StringBuilder();
        ArrayList<String> result = new ArrayList<String>();
        backtrack(string, result, 0,0, n);
        return result;
    }

    public static void backtrack(StringBuilder string, ArrayList<String> result, int openN, int closedN, int n) {
        StringBuilder newString = new StringBuilder(string);
        if (openN == closedN && openN == n) {
            result.add(string.toString());
        }

        if (openN < n) {
            string.append("(");
            backtrack(string, result, openN + 1, closedN, n);
            string.deleteCharAt(string.length()-1);
        }

        if (closedN < openN && closedN < n) {
            string.append(")");
            backtrack(string, result, openN, closedN + 1, n);
        }
    }
}

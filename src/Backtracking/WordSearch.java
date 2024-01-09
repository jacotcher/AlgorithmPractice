package Backtracking;

import java.util.ArrayList;

public class WordSearch {
    public static boolean wordSearch(char[][] grid, String word) {
        ArrayList<Integer> result = new ArrayList<>();

        backTrack(grid, word.toCharArray(), new int[]{0, 0}, 0, new int[]{grid.length -1, grid[0].length - 1}, result);
        return !result.isEmpty();
    }

    public static void backTrack(char[][] grid, char[] word, int[] currentPosition, int placeInWord, int[] gridSize, ArrayList<Integer> result) {
        if (placeInWord == word.length) {
            result.add(1);
            return;
        }
        if (currentPosition[0] == grid.length - 1 && currentPosition[1] == grid.length - 1) {
            return;
        }

        if (word[placeInWord] == grid[currentPosition[0]][currentPosition[1]]) {
            if (currentPosition[1] != gridSize[1]) {
                currentPosition[1] += 1;
                backTrack(grid, word, currentPosition, placeInWord + 1, gridSize, result);
                currentPosition[1] -=1;
            }
            if (currentPosition[0] != gridSize[0]) {
                currentPosition[0] += 1;
                backTrack(grid, word, currentPosition, placeInWord + 1, gridSize, result);
                currentPosition[0] -=1;
            }
        }

        if (currentPosition[1] != gridSize[1]) {
            currentPosition[1] += 1;
            backTrack(grid, word, currentPosition, placeInWord, gridSize, result);
            currentPosition[1] -=1;
        }
        if (currentPosition[0] != gridSize[0]) {
            currentPosition[0] += 1;
            backTrack(grid, word, currentPosition, placeInWord, gridSize, result);
            currentPosition[0] -=1;
        }
    }
}

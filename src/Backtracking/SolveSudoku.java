package Backtracking;

import java.util.ArrayList;

public class SolveSudoku {
    public static char[][] solveSudoku(char[][] board) {

        backtrack(board);

        return board;
    }

    public static void printSudoku(char[][] board) {
        System.out.println("  ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟ ͟  ");
        for (int i = 0; i < 9; i ++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.print(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }

    public static void backtrack(char[][] board) {
        for (int i = 0; i <=8; i++) {
            for(int j = 0; j <=8; j++) {
                if (board[i][j] == '.') {
                    for (int a = 1; a<=9; a++) {
                        char character = Character.forDigit(a, 10);
                        if (isValid(board, i, j, character)) {
                            board[i][j] = character;
                            if (isComplete(board)) {
                                return;
                            }
                            else {
                                backtrack(board);
                                if (isComplete(board)) {
                                    return;
                                }
                                board[i][j] = '.';
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int column, char attempt) {
        for (int i = 0; i <=8; i++) {
            if (board[row][i] == attempt) {
                return false;
            }
            if (board[i][column] == attempt) {
                return false;
            }
        }
        // Row 1
        if (row <= 2 && column <= 2) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 2 && column <= 5) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 3; j <= 5; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 2 && column <= 8) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 6; j <= 8; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        }
        // Row 2
        else if (row <= 5 && column <= 2) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 5 && column <= 5) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 3; j <= 5; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 5 && column <= 8) {
            for (int i = 3; i <= 5; i++) {
                for (int j = 6; j <= 8; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        }
        // row 3
        else if (row <= 8 && column <= 2) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 8 && column <= 5) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 3; j <= 5; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        } else if (row <= 8 && column <= 8) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 6; j <= 8; j++) {
                    if (board[i][j] == attempt) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static int[] getNextPos(char[][] board, int row, int column) {
        int counter = 0;
        while (board[row][column] != '.') {
            if (counter >= 64){
                return new int[]{0, 0};
            }
            if (column == 8 && row == 8) {
                row = 0;
                column = 0;
            }
            else if (column == 8) {
                row += 1;
                column = 0;
            }
            else {
                column +=1;
            }
        }
        return new int[]{row, column};

    }

    public static boolean isComplete(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}

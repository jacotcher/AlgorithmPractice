package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class NQueens {
    public static int solveNQueens(int n) {

        Backtracking bt = new Backtracking();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        bt.dfs(new ArrayList<Integer>(), n, res);

        System.out.println("There are " + res.size() + " possible combinations. Listed below: ");
        for (List<Integer> result: res) {
            System.out.println("___________________");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (result.get(i) == j) {
                        System.out.print("| Q");
                    }
                    else {
                        System.out.print("| _");
                    }
                }
                System.out.println("|");
            }
        }
        return res.size();
    }
}

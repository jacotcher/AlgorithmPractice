package Matrices;

import java.util.*;
public class SetMatrixZeros{
    public static int[][] setMatrixZeros(int[][] mat) {

        ArrayList<ArrayList<Integer>> zeroCoOrds = new ArrayList<>();

        // Find co-ordinates of 0s
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    ArrayList<Integer> tempCoOrd = new ArrayList<>();
                    tempCoOrd.add(i);
                    tempCoOrd.add(j);
                    zeroCoOrds.add(tempCoOrd);
                }
            }
        }

        for (ArrayList<Integer> zeroCoOrd : zeroCoOrds) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[zeroCoOrd.get(0)][j] = 0;
            }
            for (int i = 0; i < mat.length; i++) {
                mat[i][zeroCoOrd.get(1)] = 0;
            }
        }

        return mat;
    }
}
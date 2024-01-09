import CyclicSort.FindCorruptPair;
import CyclicSort.FirstMissingPositive;
import CyclicSort.MissingNumber;
import CyclicSort.MissingNumbers;
import Matrices.RotateImage;
import Matrices.SetMatrixZeros;
import TopologicalSort.CompilationOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6}
        };

        RotateImage.rotateImage(grid);
    }
}
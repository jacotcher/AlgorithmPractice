import CyclicSort.FindCorruptPair;
import CyclicSort.FirstMissingPositive;
import CyclicSort.MissingNumber;
import CyclicSort.MissingNumbers;
import Graphs.NetworkDelayTime;
import Matrices.RotateImage;
import Matrices.SetMatrixZeros;
import TopologicalSort.CompilationOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        int[][] network = new int[][]{{2,1,1},{3,2,1},{3,4,2},{4,2,1}};
        NetworkDelayTime.networkDelayTime(network,4 ,3);
    }
}
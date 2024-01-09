package Backtracking;

// Template class for backtracking using dfs
import java.util.*;
public class Backtracking{
    // To check the current state is a valid solution or not
    public boolean isSolution(List<Integer> state, int n){
        if (state.size() == n) {
            return true;
        }
        return false;
    }

    // To check the current choice is a valid choice or not
    public boolean isValid(Integer row, Integer col, List<Integer> state, ArrayList<ArrayList<Integer>> res){

        int divOffset = 0;

        for (int i = 0; i < state.size(); i++) {
            int prevCol = state.get(i);

            // If in same col return false
            if (prevCol == col) {
                return false;
            }
            // If on right diaganol return false
            else if (prevCol == col - row + divOffset) {
                return false;
            }
            // If on left diaganol return false
            else if (prevCol == col + row - divOffset) {
                return false;
            }

            divOffset+=1;
        }

        return true;
    }

    // We can use this function to evaluate all the states and store the valid states
    public void dfs(ArrayList<Integer> state, int n, ArrayList<ArrayList<Integer>> res){
        if (isSolution(state, n)){
            res.add(new ArrayList<Integer>(state)); // e.g. add a copy of the state to final result list
            return;
        }
        for (int i = 0; i < n; i ++){
            if (isValid(state.size(), i, state, res)){
                state.add(i); // make move
                dfs(state, n, res);
                int indexOfLastElement = state.size() - 1;
                state.remove(indexOfLastElement); // backtrack
            }
        }
    }
}
package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequencesInDNA {

    public static Set<String> findRepeatedSequences(String s, int k) {
        char[] dna = s.toCharArray();
        int length = dna.length;
        HashSet<String> checkedValues = new HashSet<>();
        HashSet<String> sequences = new HashSet<>();
        int start_window = 0;
        int end_window = start_window + k -1;
        while (end_window < length) {
            StringBuilder sequence = new StringBuilder();
            for (int i = start_window; i <= end_window; i++) {
                sequence.append(dna[i]);
            }
            if (checkedValues.contains(sequence.toString())) {
                sequences.add(sequence.toString());
            }
            else {
                checkedValues.add(sequence.toString());
            }
            start_window ++;
            end_window ++;
        }
        return sequences;
    }
}

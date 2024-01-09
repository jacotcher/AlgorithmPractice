package TwoPointer.ReverseWordsInAString;

public class ReverseWords {

    public static String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        String s2 = cleanSpaces(s1, s1.length);
        StringBuilder builder = new StringBuilder(s2);

        strRev(builder, 0, builder.length() - 1);

        int n = builder.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && builder.charAt(end) != ' ')
                ++end;
            strRev(builder, start, end - 1);
            start = end + 1;
            ++end;
        }

        return builder.toString();
    }

    // Function to reverse the whole string
    public static void strRev(StringBuilder sb, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = sb.charAt(startRev);
            sb.setCharAt(startRev++, sb.charAt(endRev));
            sb.setCharAt(endRev--, temp);
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        String str = new String(a, 0, n);
        str = str.replaceAll("\\s+", " ").trim();
        return str;
    }

    // Driver code
    public static void main(String[] args) {
        String[] inputs = {
                "Hello World", "We love Python",
                "The quick brown fox jumped over the lazy dog.",
                "Hey", "To be or not to be", "AAAAA", " Hello     World "};

        for(int i=0; i<inputs.length; i++){
            System.out.print(i+1);
            System.out.println(".\tActual string:\t\t"+ inputs[i]);
            System.out.println("\tReversed String:\t"+ reverseWords(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
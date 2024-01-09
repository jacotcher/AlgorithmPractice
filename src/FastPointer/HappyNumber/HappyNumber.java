package FastPointer.HappyNumber;

public class HappyNumber {
    int number;

    public HappyNumber(int number) {
        this.number = number;
    }

    public boolean isHappy() {
        int left = this.number;
        int right = getSumOfDigits(this.number);

        do {
            left = this.getSumOfDigits(left);
            int temp_right = this.getSumOfDigits(right);
            if (temp_right == 1) {
                return true;
            }
            right = this.getSumOfDigits(temp_right);

            if (right == left) {
                return false;
            }
            else if (right == 1) {
                return true;
            }

        } while (left != right);
        return false;
    }

    private int getSumOfDigits(int number) {
        String stringNum = Integer.toString(number);
        int lengthOfString = stringNum.length();
        int total = 0;
        for (int i = 0; i < lengthOfString; i++) {
            int currentNumber = Integer.parseInt(stringNum.substring(i, i+1));
            total += currentNumber*currentNumber;
            i=i;
        }
        return total;
    }
}

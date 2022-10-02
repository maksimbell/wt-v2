package task5;

public class Task5 {
    // 1 3 5 7 6 1  0 11 13
    public  int solve(int[] sequence){
        int maxAscendingLength = 0;
        int currentAscendingLength;
        boolean isAscending;

        for (int i = 0; i < sequence.length; i++) {
            isAscending = true;
            currentAscendingLength = 1;
            for (int j = i + 1; (j < sequence.length) && isAscending; j++) {
                if (sequence[j - 1] < sequence[j]) {
                    currentAscendingLength++;
                } else {
                    isAscending = false;
                }
            }
            maxAscendingLength = Math.max(maxAscendingLength, currentAscendingLength);
        }
        return sequence.length - maxAscendingLength;
    }
}

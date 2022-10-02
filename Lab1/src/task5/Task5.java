package task5;


import java.util.Scanner;

public class Task5 {
    // 1 3 5 7 6 1  0 11 13
    public static void main(String[] args) {
        System.out.println("Elements min number to delete:" + solve(getSequence()));
    }

    private static int[] getSequence(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sequence length: ");
        int arrSize = sc.nextInt();
        int[] array = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            System.out.println("Input element " + (i+1));
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int solve(int[] sequence) {
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

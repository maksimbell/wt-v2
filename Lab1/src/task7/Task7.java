package task7;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println("before:");
        printArray(array);
        shellSort(array);
        System.out.println("\nafter:");
        printArray(array);
    }

    private static int[] getArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vector length: ");
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Input element " + (i + 1));
            array[i] = sc.nextInt();
        }
        return array;
    }

    private static void shellSort(int[] array) {
        boolean isCorrect = false;
        while (!isCorrect) {
            isCorrect = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isCorrect = false;
                }
            }
        }
    }

    private static void printArray(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}

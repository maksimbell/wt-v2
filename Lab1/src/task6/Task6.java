package task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int[][] matrix = solve(getVector());
        printMatrix(matrix);
    }

    private static int[] getVector(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vector length: ");
        int arrSize = sc.nextInt();
        int[] array = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            System.out.println("Input element " + (i+1));
            array[i] = sc.nextInt();
        }
        return array;
    }
    private static int[][] solve(int[] vector) {
        int matrixOrder = vector.length;
        int[][] matrix = new int[matrixOrder][matrixOrder];

        for (int i = 0; i < matrixOrder; i++) {
            for (int j = 0; j < matrixOrder; j++) {
                matrix[i][j] = vector[(j + i) % matrixOrder];
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

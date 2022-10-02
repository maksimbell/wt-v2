package task6;

import java.math.BigInteger;
import java.util.ArrayList;

public class Task6 {

    public int[][] solve(int[] vector) {
        int matrixOrder = vector.length;
        int[][] matrix = new int[matrixOrder][matrixOrder];

        for (int i = 0; i < matrixOrder; i++) {
            for (int j = 0; j < matrixOrder; j++) {
                matrix[i][j] = vector[(j + i) % matrixOrder];
            }
        }

        return matrix;
    }
}

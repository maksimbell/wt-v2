package task8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        int[] array1 = {1,5,6};
        int[] array2 = {2,3,7};
        int[] indices = findInsertionIndexes(array1, array2);
        System.out.println(Arrays.toString(indices));
    }

    private static int[] findInsertionIndexes(int[] array1, int[] array2) {
        int[] indices = new int[array2.length];
        for (int i = 0; i < array2.length; i++) {
            boolean isInserted = false;
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] >= array2[i]) {
                    indices[i] = j - 1;
                    isInserted = true;
                    break;
                }
            }
            if (!isInserted) {
                indices[i] = array1.length - 1;
            }
        }
        return indices;
    }
}

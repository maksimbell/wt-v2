package task3;

import java.awt.*;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        double[] values = solve(1, 4, 1);
        printSolution(values);
    }
    private static double[] solve(double start, double end, double step) {
        int count = (int) Math.round((end - start)/step);
        double[] values = new double[count];

        for (int i = 0; i < count; i++){
            values[i] = Math.tan(start + i * step);
        }

        return  values;
    }

    private static void printSolution(double[] values){
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " ");
        }
    }
}

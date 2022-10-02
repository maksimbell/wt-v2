import task1.Task1;
import task2.Task2;
import task3.Task3;
import task4.Task4;
import task5.Task5;
import task6.Task6;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        double answer = task1.solve(1, 2);
        System.out.println("\n1");
        System.out.println(answer);

        Task2 task2 = new Task2();
        boolean contains = task2.solve(new Point(0, 0));
        System.out.println("\n2");
        System.out.println(contains);

        Task3 task3 = new Task3();
        double[] values = task3.solve(Math.PI, 4, 0.1);
        System.out.println("\n3");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        Task4 task4 = new Task4();
        ArrayList<Integer> indices = task4.solve(10);
        System.out.println("\n\n4");
        if (indices.isEmpty()) {
            System.out.println("No prime numbers");
        } else {
            System.out.println("Prime numbers indices:");
            Iterator<Integer> iterator = indices.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }

        Task5 task5 = new Task5();
        int[] sequence = {1, 2, 4, 5, 7, 6, 8, 9, 11};
        int elementsNumber = task5.solve(sequence);
        System.out.println("\n\n5");
        System.out.print("Elements min number to delete:" + elementsNumber);

        Task6 task6 = new Task6();
        int[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] matrix = task6.solve(vector);
        System.out.println("\n\n6");
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
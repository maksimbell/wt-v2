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

    }
}
import task1.Task1;
import task2.Task2;
import task3.Task3;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        task1.Task1 task1 = new Task1();
        double answer = task1.solve(1, 2);
        System.out.println(answer);

        task2.Task2 task2 = new Task2();
        boolean contains = task2.solve(new Point(0, 0));
        System.out.println(contains);

        task3.Task3 task3 = new Task3();
        double[] values = task3.solve(Math.PI, 2 * Math.PI, 0.1);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
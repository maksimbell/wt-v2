import task1.Task1;
import task2.Task2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        task1.Task1 task1 = new Task1();
        double answer = task1.solve(1, 2);
        System.out.println(answer + "\n");

        task2.Task2 task2 = new Task2();
        boolean contains = task2.solve(new Point(0, 0));
        System.out.println(contains + "\n");
    }
}
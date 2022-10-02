import task1.Task1;
import task2.Task2;
import task3.Task3;
import task4.Task4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        task1.Task1 task1 = new Task1();
        double answer = task1.solve(1, 2);
        System.out.println("\n1");
        System.out.println(answer);

        task2.Task2 task2 = new Task2();
        boolean contains = task2.solve(new Point(0, 0));
        System.out.println("\n2");
        System.out.println(contains);

        task3.Task3 task3 = new Task3();
        double[] values = task3.solve(Math.PI, 4, 0.1);
        System.out.println("\n3");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        task4.Task4 task4 = new Task4();
        ArrayList<Integer> indices = task4.solve(10);
        System.out.println("\n\n4");
        if(indices.isEmpty()){
            System.out.println("No prime numbers");
        }else{
            System.out.println("Prime numbers indices:");
            Iterator<Integer> iterator = indices.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
        }
    }
}
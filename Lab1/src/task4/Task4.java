package task4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> indices = solve(getLength());
        printSolution(indices);
    }

    private static int getLength(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sequence length: ");
        int length = sc.nextInt();
        return length;
    }
    private static ArrayList<Integer> solve(int length) {
        int[] array = new int[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(100);
        }
        ArrayList<Integer> indices = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            BigInteger current = BigInteger.valueOf(array[i]);
            if (current.isProbablePrime((int) Math.log(array[i])))
                indices.add(i);
        }

        return indices;
    }

    private static void printSolution(ArrayList<Integer> indices){
        if (indices.isEmpty()) {
            System.out.println("No prime numbers");
        } else {
            System.out.println("Prime numbers indices:");
            Iterator<Integer> iterator = indices.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }
    }
}

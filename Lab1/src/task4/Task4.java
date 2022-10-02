package task4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class Task4 {
    public ArrayList<Integer> solve(int length) {
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
}

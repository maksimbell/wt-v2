package task1;

import static java.lang.Math.*;

public class Task1 {

    public static void main(String[] args){
        double answer = solve(1, 2);
        System.out.println(answer);
    }
    private static double solve(double x, double y) {
        return x + (1 + pow(sin(x + y), 2)) / (2 + abs(x - (2 * x / (1 + pow(x, 2) * pow(y, 2)))));
    }
}

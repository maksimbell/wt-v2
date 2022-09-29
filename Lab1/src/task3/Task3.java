package task3;

import java.awt.*;

public class Task3 {

    public double[] solve(double start, double end, double step) {
        int count = (int) Math.round((end - start)/step);
        double[] values = new double[count];

        for (int i = 0; i < count; i++){
            values[i] = Math.tan(start + i * step);
        }

        return  values;
    }
}

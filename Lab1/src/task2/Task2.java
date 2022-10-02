package task2;

import java.awt.*;
import java.awt.geom.Area;

public class Task2 {
    private static Rectangle _topRect;
    private static Rectangle _botRect;

    public static void main(String[] args) {
        _topRect = new Rectangle(-4, 0, 8 + 1, 5 + 1);
        _botRect = new Rectangle(-6, -3, 12 + 1, 3 + 1);

        boolean contains = solve(new Point(0, 0));
        System.out.println(contains);
    }



    private static boolean solve(Point point) {
        return _topRect.contains(point) || _botRect.contains(point);
    }
}

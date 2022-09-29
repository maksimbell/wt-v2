package task2;

import java.awt.*;
import java.awt.geom.Area;

public class Task2 {
    private final Rectangle _topRect;
    private final Rectangle _botRect;

    public Task2() {
        _topRect = new Rectangle(-4, 0, 8 + 1, 5 + 1);
        _botRect = new Rectangle(-6, -3, 12 + 1, 3 + 1);
    }

    public boolean solve(Point point) {
        return _topRect.contains(point) || _botRect.contains(point);
    }
}

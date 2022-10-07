package task9x11;
import java.awt.*;

public class Task9 {
    public static void main(String[] args) {
        Basket basket = new Basket();

        basket.addBall(new Ball(Color.BLUE, 10));
        basket.addBall(new Ball(Color.CYAN, 6));
        basket.addBall(new Ball(Color.RED, 3));
        basket.addBall(new Ball(Color.MAGENTA, 9));
        basket.addBall(new Ball(Color.BLUE, 1));

        System.out.println("Weight: " + basket.getBasketWeight());
        System.out.println("Blue balls: " + basket.getBlueBallsCount());
    }
}

package task9x11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private  List<Ball> balls;

    public Basket(){
        this.balls = new ArrayList<Ball>();
    }

    public List<Ball> getBalls(){
        return this.balls;
    }

    public void addBall(Ball ball){
        this.balls.add(ball);
    }

    public int getBasketWeight(){
        int weight = 0;
        for (Ball ball:balls) {
            weight+=ball.getWeight();
        }

        return weight;
    }

    public int getBlueBallsCount(){
        int count = 0;
        for (Ball ball:balls) {
            if(ball.getColor() == Color.BLUE)
                count++;
        }

        return count;
    }
}

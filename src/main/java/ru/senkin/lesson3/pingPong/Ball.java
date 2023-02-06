package ru.senkin.lesson3.pingPong;

import java.util.Objects;

public class Ball {
    private String ball;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return Objects.equals(ball, ball1.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }

    @Override
    public String toString() {
        return ball;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public Ball(String ball) {
        this.ball = ball;
    }
}

package ru.senkin.lesson3.pingPong;

public class PingPong {
    private final Ball ball;
    private boolean waitFlag = false;

    private int kickCount = 50;

    public PingPong(Ball ball) {
        this.ball = ball;
    }

    public synchronized void ping() {
        while (this.waitFlag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ping: " + this.ball +"  отбит");
        this.waitFlag = true;
        this.kickCount = this.kickCount - 1;
        if (this.kickCount > 0) {
            notify();
        }
  }

    public synchronized void pong() {
        while (!this.waitFlag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pong: " + this.ball +" отбит");
        this.waitFlag = false;
        this.kickCount = this.kickCount - 1;
        if (this.kickCount > 0) {
            notify();
        }

    }

    }

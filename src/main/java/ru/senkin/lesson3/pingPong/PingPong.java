package ru.senkin.lesson3.pingPong;

public class PingPong {
    private final Ball ball;

    private Integer kickCount;

    private boolean waitFlag = false;


    public PingPong(Ball ball, Integer kickCount) {
        this.ball = ball;
        this.kickCount = kickCount;
    }

    public synchronized void ping() {
        while (this.waitFlag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ping: " + this.ball +" отбит");
        this.waitFlag = true;
        notify();

  }

    public Integer getKickCount() {
        return kickCount;
    }

    public void setKickCount(Integer kickCount) {
        this.kickCount = kickCount;
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
        notify();
    }

    }

package ru.senkin.lesson3.pingPong;

public class Main {
    public static void main(String[] args) {
        System.out.println("Начало игры: ping и pong");
        PingPong game = new PingPong(new Ball("МЯЧИК"));
        new Player("Alex", PingPongPosition.PING, game);
        new Player("Maria", PingPongPosition.PONG, game);
    }
}

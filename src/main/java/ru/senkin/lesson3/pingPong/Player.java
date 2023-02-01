package ru.senkin.lesson3.pingPong;


import java.util.Objects;

public class Player implements Runnable{
    private String playerName;

    private final PingPongPosition position;

    private PingPong game;

    public Player(String name, PingPongPosition position, PingPong game) {
        this.playerName = name;
        this.position = position;
        this.game = game;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while (true){
            if (this.position == PingPongPosition.PING) {
                game.ping();
            } else {
                game.pong();
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(game, player.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, game);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + playerName + '\'' +
                ", pingPong=" + game +
                '}';
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PingPong getGame() {
        return game;
    }

    public void setGame(PingPong game) {
        this.game = game;
    }


}

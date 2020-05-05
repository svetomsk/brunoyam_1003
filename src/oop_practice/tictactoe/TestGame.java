package oop_practice.tictactoe;

public class TestGame {
    public static void main(String[] args) {
        GameProcess game = new GameProcess();
        for (int i = 0; i < 2000; i++) {
            game.startGame();
        }
    }
}

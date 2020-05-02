package oop_practice.tictactoe;

public interface IPlayer {
    int[] makeTurn();
    CellValues getSymbol();
    default void notifyResults(boolean result) {
        System.out.println("player " + getSymbol() + (result ? " wins" : " loses"));
    }
}

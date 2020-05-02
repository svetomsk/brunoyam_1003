package oop_practice.tictactoe;

public interface IPlayer {
    int[] makeTurn();
    CellValues getSymbol();
}

package oop_practice.tictactoe;

import java.util.Random;

public class RandomPlayer implements IPlayer {
    private CellValues symbol;
    private Field field;

    public RandomPlayer(CellValues symbol, Field field) {
        this.symbol = symbol;
        this.field = field;
    }

    @Override
    public int[] makeTurn() {
        Random r = new Random();
        int x = r.nextInt(field.size());
        int y = r.nextInt(field.size());
        return new int[]{x, y};
    }

    @Override
    public CellValues getSymbol() {
        return symbol;
    }
}

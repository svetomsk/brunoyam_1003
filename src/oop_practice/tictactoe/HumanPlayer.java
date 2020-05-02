package oop_practice.tictactoe;

import java.util.Scanner;

public class HumanPlayer implements IPlayer {
    private CellValues symbol;
    private Field field;

    public HumanPlayer(CellValues symbol, Field field) {
        this.symbol = symbol;
        this.field = field;
    }

    @Override
    public int[] makeTurn() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new int[]{x, y};
    }

    @Override
    public CellValues getSymbol() {
        return symbol;
    }
}

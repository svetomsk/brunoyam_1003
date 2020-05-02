package oop_practice.tictactoe;

public class TestGame {
    public static void main(String[] args) {
//        Field field = new Field(3);
////        field.showField();
////
////        field.setValue(0, 1, CellValues.CROSS);
////        field.setValue(1, 1, CellValues.ZERO);
//////        field.showField();
////
////        System.out.println(field.setValue(0, 1, CellValues.ZERO));
////        field.showField();
//        field.showField();
//        HumanPlayer p = new HumanPlayer(CellValues.ZERO, field);
//        int [] coords = p.makeTurn();
//        System.out.println("x = " + coords[0] + " y = " + coords[1]);

        GameProcess game = new GameProcess();
        game.startGame();
    }
}

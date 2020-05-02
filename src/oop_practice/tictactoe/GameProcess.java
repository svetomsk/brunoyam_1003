package oop_practice.tictactoe;

public class GameProcess {
    public void startGame() {
        Field field = new Field(3);

        IPlayer first = new RandomPlayer(CellValues.CROSS, field);
        IPlayer second = new RandomPlayer(CellValues.ZERO, field);

        boolean isFirstTurn = true;

        while(true) {
            CellValues checkResult = field.checkWinner();
            if (checkResult != CellValues.EMPTY) {
                System.out.println(checkResult + " wins");
                break;
            }
            field.showField();

            IPlayer player;
            if (isFirstTurn) { // ходит первый игрок
                player = first;
            } else { // ходит второй игрок
                player = second;
            }

            System.out.println(player.getSymbol() + " player turn: ");
            int [] coords = player.makeTurn();
            int x = coords[0];
            int y = coords[1];
            boolean setResult = field.setValue(x, y, player.getSymbol());
            if (!setResult) {
                continue;
            }

            isFirstTurn = !isFirstTurn;
        }
        field.showField();
        System.out.println(Math.pow(3, 9));
    }
}

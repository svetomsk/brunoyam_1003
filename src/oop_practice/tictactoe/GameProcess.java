package oop_practice.tictactoe;

public class GameProcess {
    public void startGame() {
        Field field = new Field(3);

        IPlayer first = new HumanPlayer(CellValues.CROSS);
        IPlayer second = new StatPlayer(CellValues.ZERO, field);

        boolean isFirstTurn = true;

        while(true) {
            // проверка завершения игры
            CellValues checkResult = field.checkWinner();
            if (checkResult != CellValues.EMPTY) { // игра окончена
                first.notifyResults(checkResult == first.getSymbol());
                second.notifyResults(checkResult == second.getSymbol());
                break;
            } else {
                if (field.isDraw()) {
                    System.out.println("draw");
                    first.notifyResults(true);
                    second.notifyResults(true);
                    break;
                }
            }

            field.showField();

            IPlayer player; // игрок, который делает ход
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

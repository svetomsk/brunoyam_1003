package oop_practice.tictactoe;
public class GameProcess {
    private Field field;
    private MainFrame frame;
    private IPlayer first, second;
    boolean isFirstTurn = true;

    public void startGame() {
        field = new Field(3);

        first = new HumanPlayer(CellValues.CROSS);
        second = new StatPlayer(CellValues.ZERO, field);
        frame = new MainFrame(field, this);
        frame.setVisible(true);
        frame.setStatusText("Player " + first.getSymbol() + " turn");
    }

    private void justConsoleGame() {
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

            // выбираем игрока
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

    public void handleClick(int x, int y) {
        // выбрать игрока
        // обновить статус бар
        // попытаться сделать ход
        // если успешно, то проверить на победу/ничью
        // если победа/ничья - обновить статус бар

        // выбираем игрока
        IPlayer player; // игрок, который делает ход
        IPlayer last;
        if (isFirstTurn) { // ходит первый игрок
            player = first;
            last = second;
        } else { // ходит второй игрок
            player = second;
            last = first;
        }
        // обновили статус бар
        frame.setStatusText("Player " + last.getSymbol() + " turn");

        // совершаем ход
        if (field.setValue(x, y, player.getSymbol())) {
            CellValues checkResult = field.checkWinner();
            if (checkResult != CellValues.EMPTY) { // игра окончена
                first.notifyResults(checkResult == first.getSymbol());
                second.notifyResults(checkResult == second.getSymbol());
                frame.setStatusText("Player " + player.getSymbol() + "wins");
            } else {
                if (field.isDraw()) {
                    frame.setStatusText("Draw :)");
                    first.notifyResults(true);
                    second.notifyResults(true);
                }
            }
        }
        frame.updateField();

        isFirstTurn = !isFirstTurn;

    }
}

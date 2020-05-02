package oop_practice.tictactoe;

public class Field {
    private int size;
    private CellValues[][] data;

    public Field(int size) {
        this.size = size;
        data = new CellValues[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = CellValues.EMPTY;
            }
        }
    }

    public boolean setValue(int row, int column, CellValues value) {
        if (row < 0 || row >= size || column < 0 || column >= size ||
                data[row][column] != CellValues.EMPTY) {
            return false;
        }
        data[row][column] = value;
        return true;
    }

    public void showField() {
        for(CellValues[] row : data) {
            for (CellValues element : row) {
                String symbol = "";
                switch (element) {
                    case EMPTY: symbol = "_"; break;
                    case ZERO: symbol = "0"; break;
                    case CROSS: symbol = "X";
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public CellValues checkWinner() {
        // строка или столбец
        for (int i = 0; i < size; i++) {
            if (data[i][0] == data[i][1] && data[i][1] == data[i][2] && data[i][0] != CellValues.EMPTY) {
                return data[i][0];
            }
            if (data[0][i] == data[1][i] && data[1][i] == data[2][i] && data[0][i] != CellValues.EMPTY) {
                return data[0][i];
            }
        }
        if (data[0][0] == data[1][1] && data[1][1] == data[2][2] && data[0][0] != CellValues.EMPTY) {
            return data[0][0];
        }
        if(data[0][2] == data[1][1] && data[1][1] == data[2][0] && data[1][1] != CellValues.EMPTY) {
            return data[1][1];
        }
        return CellValues.EMPTY;
    }

    public int size() {
        return size;
    }

}

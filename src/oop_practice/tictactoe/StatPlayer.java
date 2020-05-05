package oop_practice.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StatPlayer implements IPlayer {
    private CellValues symbol;
    private Field field;

    private List<String> opponentCombinations;
    private List<String> myCombinations;
    private Statistics stats;

    public StatPlayer(CellValues symbol, Field field) {
        this.symbol = symbol;
        this.field = field;

        opponentCombinations = new ArrayList<>();
        myCombinations = new ArrayList<>();
        stats = new Statistics();
    }

    @Override
    public int[] makeTurn() {
        String otherTurn = fieldToString();
        opponentCombinations.add(otherTurn);

        int maxPriorityPos = -1; // позиция элемента, куда хотим установить значение
        int maxPriority = Integer.MIN_VALUE;
        char [] currentFieldArray = otherTurn.toCharArray();

        //find best combination
        // ____X____
        for (int i = 0; i < currentFieldArray.length; i++) {
            if (currentFieldArray[i] == '_') {
                currentFieldArray[i] = symbolToChar(symbol);
                int priority = stats.getPriority(new String(currentFieldArray));
                if (priority > maxPriority) {
                    maxPriority = priority;
                    maxPriorityPos = i;
                }
                currentFieldArray[i] = symbolToChar(CellValues.EMPTY);
            }
        }

        // select random position
        if (maxPriorityPos == -1) {
            char currentChar = '-';
            Random r = new Random();
            int pos = 0;
            while (currentChar != '_') {
                pos = r.nextInt(otherTurn.length());
                currentChar = otherTurn.charAt(pos);
            }
            maxPriorityPos = pos;
        }
        currentFieldArray[maxPriorityPos] = symbolToChar(symbol);
        myCombinations.add(new String(currentFieldArray));
        return new int[]{maxPriorityPos / field.size(), maxPriorityPos % field.size()};
        // 5 -> 1 2
    }

    @Override
    public CellValues getSymbol() {
        return symbol;
    }

    @Override
    public void notifyResults(boolean result) {
        IPlayer.super.notifyResults(result);
        if (result) {
            stats.descreasePriority(opponentCombinations);
            stats.increasePriority(myCombinations);
        } else {
            opponentCombinations.add(fieldToString());
            stats.descreasePriority(myCombinations);
            stats.increasePriority(opponentCombinations);
        }
        stats.saveStats();
    }

    private String fieldToString() {
        // X__0_X___
        String result = "";
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {
                result += symbolToChar(field.getValue(i, j));
            }
        }
        return result;
    }

    private char symbolToChar(CellValues value) {
        switch (value) {
            case ZERO: return '0';
            case CROSS: return 'X';
            default: return '_';
        }
    }
}

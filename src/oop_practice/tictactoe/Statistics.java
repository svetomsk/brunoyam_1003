package oop_practice.tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Statistics {
    private Map<String, Integer> fieldToPriority;
    private static final int WIN_INCREASE = 5;
    private static final int LOSE_DECREASE = -5;
    private static final String filename = "stats.txt";

    public Statistics() {
        fieldToPriority = new HashMap<>();
        readStats();
    }

    private void readStats() {
        try {
            Scanner sc = new Scanner(new File(filename));
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String combination = sc.next();
                int priority = sc.nextInt();
                fieldToPriority.put(combination, priority);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find file " + filename);
        }
    }

    public void saveStats() {
        try {
            PrintWriter pw = new PrintWriter(new File(filename));
            pw.println(fieldToPriority.size());
            for(String key : fieldToPriority.keySet()) {
                pw.println(key + " " + fieldToPriority.get(key));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getPriority(String field) {
        return fieldToPriority.getOrDefault(field, 0);
    }

    public void increasePriority(List<String> combinations) {
        changePriority(combinations, WIN_INCREASE);
    }

    public void descreasePriority(List<String> combinations) {
        changePriority(combinations, LOSE_DECREASE);
    }

    private void changePriority(List<String> combinations, int priorityDiff) {
        for (String combination : combinations) {
            int currentPriority = fieldToPriority.getOrDefault(combination, 0);
            fieldToPriority.put(combination, currentPriority + priorityDiff);
        }
    }
}

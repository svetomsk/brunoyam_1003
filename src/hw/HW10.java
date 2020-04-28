package hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HW10 {
    public static void main(String[] args) {
//        firstTask();
        secondTask();
    }

    public static void firstTask() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(1);
        HashSet<Integer> dataSet = new HashSet<>(data);
//        dataSet.addAll(data);
        if (data.size() == dataSet.size()) {
            System.out.println("All different");
        } else {
            System.out.println("Duplicates exist");
        }
    }

    public static void secondTask() {
        ArrayList<String> names = new ArrayList<>();
        names.add("first");
        names.add("second");
        names.add("third");

        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(12);
        ages.add(123);
        ages.add(123);

        if (names.size() != ages.size()) {
            System.out.println("Lists must have equal length");
            return;
        }

        // first variant
        HashMap<String, Integer> nameToAge = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            nameToAge.put(names.get(i), ages.get(i));
        }
        System.out.println(nameToAge.get("first"));
        System.out.println(nameToAge);

        // second variant
        // 19: ["first", "third", "fourth"]
        // 26: ["one", "two"]
        // 42: null --> []
        HashMap<Integer, List<String>> ageToNames = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            int key = ages.get(i);
            String value = names.get(i);
            List<String> currentList = ageToNames.getOrDefault(key, new ArrayList<>());
            currentList.add(value);
            ageToNames.put(key, currentList);
        }
        System.out.println(ageToNames);
    }
}

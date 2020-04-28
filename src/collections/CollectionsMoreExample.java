package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CollectionsMoreExample {
    public static void main(String[] args) {
        ArrayList<Integer> ids = new ArrayList<>();
        int n = 10; // количество элементов в списке (айди)
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            ids.add(r.nextInt(10000000));
        }
        ArrayList<Integer> uniqueIds = new ArrayList<>();
        uniqueIds.addAll(new HashSet<>(ids));

        int k = 1000; // количество запросов на поиск
        int cnt = 0;
        System.out.println("List size = " + uniqueIds.size());
        long startTime = System.currentTimeMillis(); // текущее время в миллисекундах
        for (int i = 0; i < k; i++) {
            int currentSearchValue = r.nextInt(10000000);
            if (uniqueIds.contains(currentSearchValue)) { // O(N)
                cnt++;
            } else {
//                System.out.println("no");
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);

        HashSet<Integer> setOfIds = new HashSet<>(uniqueIds);
        System.out.println("Set size = " + setOfIds.size());
        startTime = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            int currentSearchValue = r.nextInt(10000000);
            if (setOfIds.contains(currentSearchValue)) { // O(1)
                cnt++;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }
}

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        System.out.println(linked);

        linked.set(0, 100);
        System.out.println(linked);

        int n = 100000;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> another = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
            another.add(i);
        }

        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.get(n/2);
        }
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            another.get(n/2);
        }
        System.out.println(System.currentTimeMillis() - time);

    }
}

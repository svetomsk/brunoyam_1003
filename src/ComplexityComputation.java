import java.util.ArrayList;
import java.util.Random;

public class ComplexityComputation {
    public static void main(String[] args) {
        // 3 действия = константная сложность = O(1) = const * 1
        int a = 12;
        int b = 13;
        int c = a + b;

        // n + 3 действий = линейная сложность = O(n) = const * n
        // O(1)
        int n = 100000;
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();

        // 0(n)
        // количество миллисекунде с 1 января 1970
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        for (int i = 0; i < n; i++) { // n действий
            list.add(r.nextInt(100));
        }
        System.out.println(startTime + " " +  System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - startTime);
        // O(1) + O(n) = O(n)

        // O(n^2) + O(n^4) + O(n^3) = O(n^4)

        // O(n^2)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) { // n действийы
            for (int j = 0; j < n; j++) { // n действий
                int sum = list.get(i) + list.get(j);
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StreamingAPI {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }

        Collections.sort(data);
        data = new ArrayList<>(new HashSet<>(data));
        for(Integer element : data) {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }

        data.stream()
                .filter(element -> element % 2 == 0)
                .sorted()
                .distinct()
                .forEach(element -> System.out.println(element));

    }

    public void filter() {

    }
}

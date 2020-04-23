import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionMethods {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);

        // перемешивание данных
        Collections.shuffle(data);
        System.out.println(data);

        // сортировка по возврастанию
        Collections.sort(data);
        System.out.println(data);

        // данные в обратном порядке
        Collections.reverse(data);
        System.out.println(data);

        List<Integer> a = new LinkedList<>();
        a.add(12313);

        List<Integer> singleElementList =  Collections.singletonList(123456);

        System.out.println(singleElementList);
        List<Integer> emptyList = Collections.emptyList(); // new ArrayList<Integer>();
        System.out.println(emptyList);

//        Collections.fill(data, 0);
//        System.out.println(data);

        System.out.println(Collections.max(data));
        System.out.println(Collections.min(data));
    }
}

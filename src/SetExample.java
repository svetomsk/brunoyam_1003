import java.util.HashSet;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // hash-функция
        // объект --> int
        // 1. Если hash двух объектов не совпадает --> объекты точно различные
        // 2. Если hash двух объектов совпадает --> нужно проверить равенство полностью
        String first = "1234"; // 31 * '1' + 31*31*'2' + 31 * 31 * 31 * '3'
        System.out.println(first.hashCode());
        String second = "1235";
        System.out.println(second.hashCode());
        if (first.hashCode() != second.hashCode()) {
            System.out.println("not equal");
        }

        Integer number = 123;
        System.out.println(number.hashCode());

        HashSet<String> names = new HashSet<>();
        names.add("Svet");
        System.out.println(names);
        names.add("Svet");
        System.out.println(names);
        names.add("Ivan");
        System.out.println(names);
        for(String name : names) {
            System.out.println(name + "!");
        }
        System.out.println(names.contains("Petr"));
        System.out.println(names.size());


        // TreeSet
        // основано на дереве поиска
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers);
        numbers.remove(2);
        System.out.println(numbers);
        System.out.println(numbers.size());

    }
}

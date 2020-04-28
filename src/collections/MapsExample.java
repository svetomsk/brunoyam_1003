package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsExample {
    public static void main(String[] args) {
        // ассоциативный массив
        HashMap<String, Integer> nameToAge = new HashMap<>();
        nameToAge.put("Svetozar", 24); // сохраняет пару
        System.out.println(nameToAge);
        int age = nameToAge.get("Svetozar"); // по ключу возвращает значение
        System.out.println(age);
        nameToAge.put("Ivan", 24);

        System.out.println(nameToAge.keySet());
        System.out.println(nameToAge.values());
        ArrayList<Integer> ages = new ArrayList<>(nameToAge.values());
        System.out.println("Ivan is " + ages.get(0) + " years old");
        System.out.println("Ivan is " + nameToAge.get("Ivan") + " years old");

        int oldValue = nameToAge.put("Ivan", 43);
        System.out.println(oldValue);
        System.out.println(nameToAge);

        System.out.println(nameToAge.get("Petr"));
        System.out.println(nameToAge.getOrDefault("Petr", 0));

        nameToAge.putIfAbsent("Ivan", 123);
        nameToAge.putIfAbsent("Petr", 23);
        System.out.println(nameToAge);

        System.out.println(nameToAge.containsKey("Petr"));
        System.out.println(nameToAge.containsKey("Ivann"));
        System.out.println(nameToAge.containsValue(24));
        System.out.println(nameToAge.containsValue(25));

        System.out.println("size = " + nameToAge.size());

        HashMap<String, List<Integer>> nameToIds = new HashMap<>();
        nameToIds.put("first", new ArrayList<>());
        nameToIds.get("first").add(1);
        System.out.println(nameToIds);
    }
}

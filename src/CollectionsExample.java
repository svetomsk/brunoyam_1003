import java.util.ArrayList;

public class CollectionsExample {
    public static void main(String[] args) {
        int [] a = new int[10];

        // саморасширяющийся массив
        ArrayList<Integer> array = new ArrayList<>();
        // добавляет элемент в коцен списка
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array);
        // обращение к элементу по индексу
        int first = a[0];
        int firstList = array.get(0);

        // установка значения в ячейку по индексу
        a[0] = 15;
        array.set(0, 15);

        // количество элементов
        System.out.println(a.length);
        System.out.println(array.size());

        array.add(10);
        System.out.println(array);
        System.out.println(array.size());

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        for(int i : a) {
            System.out.println(i);
        }

        for(Integer i : array) {
            System.out.println(i);
        }
    }
}

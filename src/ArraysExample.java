public class ArraysExample {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("Длина = " + values.length);
        System.out.println(values[0]);
//        System.out.println(values[1]);
//        values[0] = 10;
//        System.out.println(values[0]);
//        values[2] = values[0] + values[1];
//        System.out.println(values[2]);

        int[] numbers = new int[5];
        System.out.println(numbers[1]);

        String[] names = new String[3];
        System.out.println(names[0]);

        String name = names[0];
//        System.out.println(names[0].length());
        System.out.println(names.length);

        System.out.println(names);
        System.out.println(values);
        System.out.println(names);

        for (int i = 0; i < values.length; i++) {
//            System.out.println(i);
            System.out.println(i + " " + values[i]);
        }

        // for-each
        for (int el : values) {
            System.out.println(el);
        }

        // #1 Посчитать сумму элементов массива
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        System.out.println(sum);

        // #2 Посчитать сумму элементов на нечетных позиция
        // v.1
        sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 != 0) {
                sum += values[i];
            }
        }
        System.out.println(sum);

        // v.2
        sum = 0;
        for (int i = 1; i < values.length; i = i + 2) {
            sum += values[i];
        }
        System.out.println(sum);


        // элементы в обратном порядке
        int [] a = {43, 23, 21};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[a.length - 1 - i]);
        }

        String s = "";

        for(int el : a) {
//            int el = 13;
            s = el + " " + s;
        }

        System.out.println(s);

    }
}

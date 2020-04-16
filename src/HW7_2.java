import java.util.ArrayList;

public class HW7_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            list.add(i);
        }
        System.out.println(list);

        for (int i = 0; i < list.size() / 2; i++) {
            int left = i;
            int right = list.size() - 1 - i;
            int tmp = list.get(left); // int tmp = a[left];
            list.set(left, list.get(right)); // a[left] = a[right]
            list.set(right, tmp); // a[right] = tmp;
        }
        System.out.println(list);

        for(Integer el : list) {
            if (el % 2 == 0) {
                System.out.print(el + " ");
            }
        }
    }
}

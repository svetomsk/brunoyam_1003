import java.util.Arrays;

public class ArgumentsExample {
    static int sumOfElements(int [] array) {
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        return sum;
    }

    void sum(int a, int b) {
        a = 1;
    }

    static int [] reverse(int [] array) {
        // int [] array = a;
        System.out.println("array value: " + array);
        array[0] = 1000;
        int [] result = new int[array.length];
        result = Arrays.copyOf(array, result.length);

        for (int i = 0; i < array.length / 2; i++) {
            int tmp = result[i];
            result[i] = result[array.length - 1 - i];
            result[array.length - 1 - i] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] a = {1, 2, 3};
        int [] b = a;
        int [] c = a;
        c[0] = 12;
        System.out.println("a value: " + a);
        System.out.println(sumOfElements(a));

        System.out.println(Arrays.toString(reverse(a)));
        System.out.println(Arrays.toString(a));
    }
}

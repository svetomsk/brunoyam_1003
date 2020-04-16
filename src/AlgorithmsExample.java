public class AlgorithmsExample {
    public static void main(String[] args) {
        int [] data = {1, 2, 3};
        System.out.println(findElement(data, 1));

        // list of 1000 elements
        // 1000 операций remove(0)
        // n * (n - 1) / 2 = O(n^2)

        // два списка, каждый по n элементов
        // проверяем наличие каждого элемента из А в списке Б
        // n = 2^32 -> log(n) = 32
    }

    public static boolean findElement(int [] a, int element) {
        for(int i : a) { // O(n), n - длина массива
            if (i == element) {
                return true;
            }
        }
        return false;
    }
}

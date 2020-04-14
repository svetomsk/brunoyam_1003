public class Constants {
    final int MAX_VALUE = 10;

    public static void main(String[] args) {
        final int a = 12;

//      запрещаем переприсваивание, но разрешаем изменять содержимое
        final int [] array = {1, 2, 3};
        array[0] = 12;

//        не работает
//        array = new int[10];

        int [] data = {1, 2};
        data = new int[10];
    }

    public void changeArray(final int [] a) {
        // здесь мы не можем пересоздать объект
//        a = new int[10];
    }
}

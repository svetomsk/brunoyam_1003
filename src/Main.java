public class Main {
    //    psvm
    public static void main(String[] args) { // главный метод
//      Здесь мы пробуем печатать что-то на экран
//      System.out - стандартный поток вывода
        System.out.println("==========");
        System.out.println("Hello, world!");
        System.out.println("Some text");
        System.out.println("==========");


        int first = 10;
        int second = 25;

        int result = first + second;
        System.out.println(result);
        result = first - second;
        System.out.println(result);
        result = first * second;
        System.out.println(result);
        result = second / first;
        System.out.println(result);
        result = second % first;
        System.out.println(result);
        System.out.println("=====");


        double x = 9.0;
        double y = 4.0;

        double c = Math.sqrt(x * x + y * y); // sqrt(x^2 + y^2)
        System.out.println(c);

        System.out.println(x / y);

        double a = 1;
        double b = 2;
        double d = 3;
        double average = (a + b + d) / 3;
        System.out.println(average);


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    // поле класса
    // глобальная переменная
    static Scanner input = new Scanner(System.in);
    static String[] names = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
    static int[] startDay = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    // объявление переменной | declaration
    static double [] weather;

    // "модификаторы доступа" "тип возвращаемого значения" "имя метода"("аргументы")
    // modifiers: public, private, protected
    // static
    private static int getMonthPosition(String monthName, String[] names) {
        // String monthName = month;
        // String [] names = names;
        // локальная переменная
        int monthIndex = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(monthName)) {
                monthIndex = i;
                break;
            }
        }

        // для возврата значения
        return monthIndex;
    }

    static double calculateAverageTemperaturePerMonth() {
        String month = input.next();
//        int k = Integer.valueOf(input.next());
        // поиск позиции месяца в списке
        int indexOfMonth = getMonthPosition(month, names); // как будто подстановка

        // считаем среднее за выбранный месяц
        double sumOfTemp = 0;
        int firstDay = startDay[indexOfMonth];
        int lastDay = startDay[indexOfMonth + 1];
        for (int i = firstDay; i < lastDay; i++) {
            sumOfTemp += weather[i];
        }
        return sumOfTemp / (lastDay - firstDay);
    }

    static void calculateMinPerMonth() {
        String month = input.next();

        // поиск позиции месяца в списке
        int monthIndex = getMonthPosition(month, names);

        int firstDay = startDay[monthIndex];
        int firstDayNextDay = startDay[monthIndex + 1];
        double minimum = weather[firstDay];
        for (int i = firstDay; i < firstDayNextDay; i++) {
            if (weather[i] < minimum) {
                minimum = weather[i];
            }
        }
        System.out.println("Min temp in " + names[monthIndex] + " was = " + minimum);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));

        int n = sc.nextInt();
        System.out.println("Number of days: " + n);
        // определение переменной (установка значение) definition
        weather = new double[n];
        for (int i = 0; i < n; i++) {
            weather[i] = sc.nextInt();
        }

        // создаем метку для цикла
        my_loop:
        while (true) {
            String operation = input.next();

            switch (operation) {
                case "exit":
                    break my_loop;
                case "average": {
                    double average = calculateAverageTemperaturePerMonth();
                    System.out.println("Average temp was " + average);
                    break;
                }
                case "min": {
                    calculateMinPerMonth();
                    break;
                }
                case "max": {

                }
                default:
                    break;
            }
        }
    }
}

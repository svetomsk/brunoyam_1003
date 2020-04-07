import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile { // //
 // "модификаторы доступа" "тип возвращаемого значения" "имя метода"("аргументы")
    // modifiers: public, private, protected
    // static
    private static int getMonthPosition(String monthName, String[] names) {
        // String monthName = month;
        // String [] names = names;
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

    public static void main(String[] args) throws FileNotFoundException {
//        Integer.toString(12);
//        Scanner.nextInt();
        Scanner sc = new Scanner(new File("data.txt"));

        int n = sc.nextInt();
        System.out.println("Number of days: " + n);
        double[] weather = new double[n];
        for (int i = 0; i < n; i++) {
            weather[i] = sc.nextInt();
        }


        String[] names = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        int[] startDay = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        Scanner input = new Scanner(System.in);
        while (true) {
            String operation = input.next();

            if (operation.equals("exit")) {
                break;
            } else if (operation.equals("average")) {
                String month = input.next();

                // поиск позиции месяца в списке
                int monthIndex = getMonthPosition(month, names); // как будто подстановка

                // считаем среднее за выбранный месяц
                double sumOfTemp = 0;
                int firstDay = startDay[monthIndex];
                int firstDayNextDay = startDay[monthIndex + 1];
                for (int i = firstDay; i < firstDayNextDay; i++) {
                    sumOfTemp += weather[i];
                }
                System.out.println("Average temp in " + names[monthIndex] + " was " + sumOfTemp /(firstDayNextDay - firstDay) );
            } else if(operation.equals("min")) {
                String month = input.next();

                // поиск позиции месяца в списке
                int monthIndex = getMonthPosition(month, names);

                int firstDay = startDay[monthIndex];
                int firstDayNextDay = startDay[monthIndex + 1];
                double minimum = weather[firstDay];
                for (int i = firstDay; i < firstDayNextDay; i++) {
                    if(weather[i] < minimum) {
                        minimum = weather[i];
                    }
                }
                System.out.println("Min temp in " + names[monthIndex] + " was = " + minimum);
            }
        }
        System.out.println("Data loaded successfully");
    }
}

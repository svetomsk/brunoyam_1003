import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static String[] namesOfmonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
    static int[] firstdayOfmonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    static int[] weather;
    static int monthPosition;

    public static double rounding(double x, int z) {
        return Math.round(x * Math.pow(10, z)) / Math.pow(10, z);
//        int k = 1;
//        for (int i = 0; i < z; i++) {
//            k *= 10;
//        }
//        double prom = 0;
//        double result = 0;
//        if (z == 0) {
//            prom = (int) x;
//            if ((int) ((x - prom) * 10) < 5) {
//                result = prom;
//            } else {
//                result = prom + 1;
//            }
//        } else {
//            prom = (int) (x * k);
//            result = prom / k;
//
//            if ((int) ((x - result) * k * 10) >= 5) {
//                result = (result * k + 1) / k;
//            }
//        }
//        return result;
    }

    public static int getMonthPosition(String inputMonth) {
        for (int i = 0; i < namesOfmonths.length; i++) {
            if (namesOfmonths[i].equals(inputMonth)) {
                monthPosition = i;
            }
        }
        return monthPosition;
    }


    public static int weatherbyDay() {
        String input = sc.next();
        int day = sc.nextInt();
        return weather[firstdayOfmonth[getMonthPosition(input)] + day - 1];
    }

    public static double average(int firstDay, int lastDay) {
        int sum = 0;
        for (int i = firstDay; i < lastDay; i++) {
            sum += weather[i];
        }
        return (double) sum / (lastDay - firstDay);

    }

    public static int MinimumInMonth(String month) {
        int min = weather[firstdayOfmonth[getMonthPosition(month)]];
        for (int i = firstdayOfmonth[getMonthPosition(month)]; i < firstdayOfmonth[getMonthPosition(month) + 1]; i++) {
            if (min > weather[i]) {
                min = weather[i];
            }
        }
        return min;
    }

    public static int MaximumInMonth(String month) {
        int max = weather[firstdayOfmonth[getMonthPosition(month)]];
        for (int i = firstdayOfmonth[getMonthPosition(month)]; i < firstdayOfmonth[getMonthPosition(month) + 1]; i++) {
            if (max < weather[i]) {
                max = weather[i];
            }
        }
        return max;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scfile = new Scanner(new File("data.txt"));
        int n = scfile.nextInt();
        System.out.println(rounding(12.222, 2));
        System.out.println("Number of days is " + n);
        weather = new int[n];
        for (int i = 0; i < n; i++) {
            weather[i] = scfile.nextInt();
        }

        my_loop:
        while (true) {
            System.out.print("Your request:");
            switch (sc.next()) {
                case "exit":
                    break my_loop;
                case "temperature":
                    System.out.println("Temperature of this day is " + weatherbyDay());
                    break;
                case "average":
                    String parts[] = sc.nextLine().split(" ");
                    if (parts.length < 3) {
                        System.out.println("Average temperature is " + rounding(average(firstdayOfmonth[getMonthPosition(parts[1])], firstdayOfmonth[getMonthPosition(parts[1]) + 1]), 1));
                    } else if (parts.length == 3) {
                        System.out.println("Average temperature is " + rounding(average(firstdayOfmonth[getMonthPosition(parts[1])], firstdayOfmonth[getMonthPosition(parts[2]) + 1]), 1));

                    }
                    break;
                case "min":
                    String inputMinmonth = sc.next();
                    System.out.println("Minimum of " + inputMinmonth + " is " + MinimumInMonth(inputMinmonth));
                    break;
                case "max":
                    String inputMaxmonth = sc.next();
                    System.out.println("Maximum of " + inputMaxmonth + " is " + MaximumInMonth(inputMaxmonth));
                    break;
            }
        }
        System.out.println("File read successfully!");
    }
}

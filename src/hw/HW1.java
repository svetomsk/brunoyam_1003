package hw;

import java.util.ArrayList;
import java.util.List;

public class HW1 {
    public static void main(String[] args) {
        int value = 145;
        if (value % 2 == 0) {
            System.out.println("Четное");
        } else {
            System.out.println("Нечетное");
        }

        int a = 10;
        int b = 9;
        int c = 8;
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String name = "Hello";
        int len = name.length();
        char symbol = name.charAt(3);
        System.out.println(symbol);
        System.out.println(name.substring(2));

        String first = "10";
        String second = "5";
        System.out.println(first + " " + second);
        int firstNumeric = Integer.valueOf(first);
        int secondNumeric = Integer.valueOf(second);
        System.out.println(firstNumeric + secondNumeric);

//        Integer number = null;
//        System.out.println(number + 1);
        int numberInt = 0;
//        List<Integer> list = new ArrayList<>();
//
//        List<int> listInt = new ArrayList<>();

        int age = 24;
        String ageString = "I'm " + age + " year old";
        System.out.println(ageString);

        System.out.println(String.valueOf(age).length());

        int bit32 = 123;
        long bit64= 1000;
        bit32 = (int) bit64;
        bit64 = bit32;

        double r = 12.456;

        System.out.println(r);
        System.out.println((int)r);
        System.out.println((double)bit32);
        System.out.println(Math.floor(r));
        System.out.println(Math.round(r));
    }
}

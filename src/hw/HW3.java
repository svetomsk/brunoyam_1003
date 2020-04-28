package hw;

public class HW3 {
    public static void main(String[] args) {
        int [] data = {2, -3, 4, 5, -3, -5};
        System.out.println("Положительные элементы: ");
        for(int i : data) {
            if(i > 0) {
                System.out.println(i);
            }
        }

        int sum = 0;
        for(int i : data) {
            if(i > 0) {
                sum++;
            }
        }
        System.out.println("Количество положительных отрицательных: " + sum);

        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < data.length; i++) {
            if(i % 2 == 0) {
                sumEven += data[i];
            } else {
                sumOdd += data[i];
            }
        }
        System.out.println(sumEven - sumOdd);

        boolean check = true;
        for(int i : data) {
            if(i >= 0) {
                check = false;
            }
        }
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");

        check = true;
        for (int i = 0; i < data.length - 1; i++) {
            if(data[i] > data[i + 1]) {
                check = false;
            }
        }
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");

        int first = data[0];
        int second = data[1];
        for(int i : data) {
            if (i > first) {
                second = first;
                first=  i;
            } else if(i > second) {
                second = i;
            }
        }
        System.out.println("First = " + first);
        System.out.println("Second = " + second);

        int number = 3;
        check = false;
        for(int i : data) {
            if(number == i) {
                check = true;
            }
        }
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");

        double sumOfElements = 0;
        for(int i : data) {
            sumOfElements += i;
        }
        System.out.println("Average = " + (sumOfElements / data.length));
    }
}

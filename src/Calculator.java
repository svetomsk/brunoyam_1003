import java.util.Scanner;

public class Calculator {
    int a = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String name = sc.next();
//        System.out.println("Hello, " + name);
        double result = 0;
        while(true) {
            System.out.println("Текущее значение = " + result);
            String operation = sc.next().trim();
            if (operation.equals("exit")) {
                break;
            }
            int number = sc.nextInt();
            String s = "+";
            switch (operation) {
                case "+": {
                    result += number;
                    break;
                }
                case "-": {
                    result -= number;
                    break;
                }
                case "*": result *= number; break;
                case "/": result /= number; break;

            }
        }
    }
}

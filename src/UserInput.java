import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int operation = sc.nextInt();
        if (operation == 0) {
            System.out.println(a + b);
        } else if(operation == 1) {
            System.out.println(a - b);
        } else if(operation == 2) {
            System.out.println(a * b);
        } else if(operation == 3) {
            System.out.println( a / b);
        } else {
            System.out.println("Unknown command");
        }
    }
}

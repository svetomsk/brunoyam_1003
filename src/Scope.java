import java.awt.*;
import java.util.Scanner;

public class Scope {
    public static void main(String[] args) {
        int a = 1;
        if (a == 2) {
            int b = 2;
        }
        for (int i = 0; i < 10; i++) {

        }
        int i = 10;

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] parts = input.split(" ");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        if(parts.length > 2) {
            System.out.println(parts[2]);
        }


        Point p = new Point(1, 2);
        p.x = 2;
        p.y = 3;
    }
}

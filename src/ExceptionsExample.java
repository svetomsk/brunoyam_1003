import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsExample {
    public static void main(String[] args) throws FileNotFoundException {
        int [] a = {1, 2, 3};
//        a[-1] = 23;
        try {
            a[-1] = 12;
//            a[1] = 12;
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Index must be from 0 to " + a.length);
        }
        System.out.println("Finish");

        try {
            Scanner sc = new Scanner(new File("data1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found :(");
        } catch (InputMismatchException exc) {
            System.out.println("Input mismatch");
        }

//        Scanner scanner = new Scanner(new File("data1.txt"));

        call();

        divide(1, 0);
    }

    public static void call() throws FileNotFoundException {
        tryOpenScanner();
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Так не пойдет");
        }
        return a / b;
    }

    public static void tryOpenScanner() throws FileNotFoundException, InputMismatchException {
        Scanner sc = new Scanner(new File("data.txt"));
        int n = sc.nextInt();
    }
}

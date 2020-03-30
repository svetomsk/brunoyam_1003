import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        int n = sc.nextInt();
        System.out.println("Number of days: " + n);
        double [] weather = new double[n];
        for(int i = 0; i < n; i++) {
            weather[i] = sc.nextInt();
        }
        System.out.println("Data loaded successfully");
    }
}

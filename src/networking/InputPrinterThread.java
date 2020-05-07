package networking;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputPrinterThread extends Thread {
    private Scanner inputScanner;
    public InputPrinterThread(Socket connection) {
        try {
            inputScanner = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // основная работа потока
        String message = "";
        while (!message.equalsIgnoreCase("exit")) {
            System.out.println(message);
            message = inputScanner.nextLine();
        }
        System.out.println("Input thread finished");
    }
}

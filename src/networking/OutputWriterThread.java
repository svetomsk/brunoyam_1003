package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class OutputWriterThread extends Thread {
    private PrintWriter writer;

    public OutputWriterThread(Socket connection) {
        try {
            writer = new PrintWriter(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String message = sc.nextLine();
            writer.println(message);
            writer.flush();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}

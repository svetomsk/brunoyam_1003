package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket connection = new Socket("localhost", 12345);
        InputPrinterThread inputThread = new InputPrinterThread(connection);
        OutputWriterThread writerThread = new OutputWriterThread(connection);
        inputThread.start(); // NOT RUN
        writerThread.start();
        System.out.println("Threads started");

        inputThread.join();
        writerThread.join();
//        InputStream in = connection.getInputStream();
//        Scanner sc = new Scanner(in);
//
//        OutputStream out = connection.getOutputStream();
//        PrintWriter pw = new PrintWriter(out);
//
//        String message = "hello, server";
//        pw.println(message);
//        pw.flush(); // очистка буфера записи
//
//        String answer = sc.nextLine();
//        System.out.println("From server: " + answer);
//
//        sc.close();
//        pw.close();
    }
}

package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ip адрес
        // 192.168.23.42    255.255.255.255
        // 192.168.0.1
        // 192.168.0.2
        // 192.168.0.3
        // 192.168.0.4
        // localhost 127.0.0.1
        // 0...65365
        // полный адрес адрес сервера ip:port

        // Socket - объект сетевого взаимодействия
        ServerSocket server = new ServerSocket(12345);
        // ip:12345
        server.setReuseAddress(true);
//        server.bind(new InetSocketAddress("localhost", 12345));
        Socket connection = server.accept();
        InputPrinterThread inputThread = new InputPrinterThread(connection);
        OutputWriterThread writerThread = new OutputWriterThread(connection);
        inputThread.start(); // NOT RUN
        writerThread.start();
        System.out.println("Threads started");

        inputThread.join();
        writerThread.join();
//        InputStream in = connection.getInputStream(); // поток входящей информации
//        Scanner sc = new Scanner(in);
//
//        OutputStream out = connection.getOutputStream(); // поток исходящей информации
//        PrintWriter pw = new PrintWriter(out);
//
//        String message = sc.nextLine();
//        System.out.println("Message from client = " + message);
//        pw.println(message);
//        pw.flush();
//
//        sc.close();
//        pw.close();
    }
}

package tasks.task07_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 29/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private int port;

    public Client(int port) {
        this.port = port;
        Scanner scan = new Scanner(System.in);
        System.out.println("Print \"exit\" when you want to exit\r\nEnter your name:");
        String helloMsg = scan.nextLine();

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(helloMsg);
            Receiver receiver = new Receiver();
            receiver.start();
            String str = "";

            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }
            receiver.setStop();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("< error connection >");
        } finally {
            close();
        }
    }

    public static void main(String[] args) {
        Client cl = new Client(3777);
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Threads are not closed");
        }
    }


    private class Receiver extends Thread {
        private boolean stop;

        public void setStop() {
            stop = true;
        }

        @Override
        public void run() {
            try {
                while (!stop) {
                    String str = in.readLine();
                    if (str == null) {
                        System.out.println("< server disconnected >");
                        Client.this.close();
                        System.exit(0);
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Error receiving message");
                e.printStackTrace();
            }
        }
    }
}

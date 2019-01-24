package lections.lec08.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Server {
    public static final int PORT = 2000;

    public static void main(String[] args) {

        System.out.println("start listening...");
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept()) {


            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.write("Hello client\n");
            output.flush();

            String str = input.readLine();
            System.out.println(str);
            output.write(str);
            output.flush();


        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}

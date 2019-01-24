package lections.lec08.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", Server.PORT)) {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            output.write("Hello server");
            output.flush();

            String str = input.readLine();
            System.out.println(str);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("client done");
    }
}

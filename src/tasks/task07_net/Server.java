package tasks.task07_net;

import tasks.task04_concurrency.Loger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 29/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Server {
    private ServerSocket server;
    private int port;
    private List<Connection> connections = Collections.synchronizedList(new ArrayList<>());


    public Server(int port) {
        this.port = port;
        try {
            Loger.i("starting server");
            server = new ServerSocket(port);
            Loger.i("waiting clients");

            while (true) {
                Socket socket = server.accept();
                Connection connection = new Connection(socket);
                connections.add(connection);
                connection.start();
                Loger.i("client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!connections.isEmpty()) {
                closeAll();
            }
        }
    }

    public static void main(String[] args) {
        Server srv = new Server(3777);
    }

    private void closeAll() {
        try {
            server.close();
            synchronized (connections) {
                Iterator<Connection> iterator = connections.iterator();
                while (iterator.hasNext()) {
                    (iterator.next()).close();
                }
            }
        } catch (Exception e) {
            System.err.println("Threads are not closed");
        }
    }


    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private String name = "";


        public Connection(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }


        public void broadcastMessage(String msg) {
            Loger.i(msg);
            msg = "< " + msg + " >";
            synchronized (connections) {
                Iterator<Connection> iterator = connections.iterator();
                while (iterator.hasNext()) {
                    (iterator.next()).out.println(msg);
                }
            }
        }


        @Override
        public void run() {
            try {
                name = in.readLine();
                broadcastMessage(name + " connected");

                while (true) {

                    String str = in.readLine();
                    if ("exit".equals(str) || (str == null)) {
                        break;
                    }
                    broadcastMessage(name + ": " + str);
                }
                broadcastMessage(name + " - has left");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }


        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);
                if (connections.size() == 0) {
                    Server.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Threads are not closed");
            }
        }
    }
}

package lab10_w;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(20500)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable r = new ServerThread(socket);
                Thread t = new Thread(r);
                t.start();
            }
        }
    }
}

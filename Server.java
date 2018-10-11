import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket connection;
    private Socket client;
    private static Server SERVER;

    public static void main(String[] args) {
        SERVER = new Server();
        try {
            SERVER.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the server
     * @throws IOException
     */
    public void run() throws IOException {
        connection = new ServerSocket(4444);
        client = connection.accept();
        System.out.println("Connected!");
    }
}

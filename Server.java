import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket connection;
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
        connection = new ServerSocket(7050);
        try (Socket client = connection.accept();
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            System.out.println("Connected!");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);

                String response = "";
                for (int i = inputLine.length()-1; i >= 0; i--)
                    response += inputLine.charAt(i);
                out.println("SERVER - " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

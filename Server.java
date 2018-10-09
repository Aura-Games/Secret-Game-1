import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class Server {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(4444);
      Socket clientSocket = serverSocket.accept();
      System.out.println("Connected!")
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

import java.net.*;
import java.io.*;

public class Client{
  private Socket connection;
  private InputStream in;
  private OutputStream out;
  private static Client CLIENT;
  public static void main(String[] args){
    CLIENT = new Client();
    try{
      CLIENT.run();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public void run() throws IOException{
    connection = new Socket("localhost", 4444);
    in = connection.getInputStream();
    out = connection.getOutputStream();
    System.out.println("Connected!");

  }
}

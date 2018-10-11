import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client{
    private Socket connection;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;
    private static Client CLIENT;
    public static final String IP = "137.205.37.210";

    public static void main(String[] args){
        CLIENT = new Client();
        try{
            CLIENT.run();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Runs the client
     * @throws IOException
     */
    public void run() throws IOException{
        connect();
        scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nWrite Message:");
            String message = scanner.nextLine();
            sendMessage(message);
            if(!waitForMessage()) break;
        }
        close();
    }
    public void connect() throws IOException{
        System.out.println("Attempting Connection...");
        connection = new Socket(IP, 7050);
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        out = new PrintWriter(connection.getOutputStream(), true);
        System.out.println("Connected!");
    }
    public void sendMessage(String message) throws IOException{
        out.println("CLIENT - "+message);
        System.out.println("CLIENT - "+message);
    }
    public boolean waitForMessage() throws IOException{
        String message = in.readLine();
        if(message=="SERVER - END"){
            close();
            System.out.println("Server closed by host");
            return false;
        }
        System.out.println(message);
        return true;
    }
    public void close() throws IOException{
        in.close();
        out.close();
        connection.close();
    }
}

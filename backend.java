import java.io.*;
import java.net.*;

public class backend {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("server on");
        while (true) {
            Socket cliSocket = serverSocket.accept();
            System.out.println("Client linked");
    
            BufferedReader in = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
            PrintWriter out = new PrintWriter(cliSocket.getOutputStream(), true);
    
            String message = in.readLine();
            System.out.println(message);
    
            out.println(message);
        }
    }
}

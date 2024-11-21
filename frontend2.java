import java.io.*;
import java.net.*;
import java.util.Scanner;

public class frontend2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        Scanner text = new Scanner(System.in);
        System.out.println("message here ");
        String textmsg = text.nextLine();
        out.println(textmsg);
        String response = in.readLine();
    }
}

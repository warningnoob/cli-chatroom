import java.io.*;
import java.net.*;
import java.util.Scanner;

public class frontend2 {
    public static void main(String[] args) throws IOException {
        // Server setup
        Socket socket = new Socket("10.93.41.226", 9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Create a single Scanner instance
        Scanner scanner = new Scanner(System.in);

        // Get username
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        try {
            while (true) {
                // Input message
                System.out.println("Enter your message (or type 'exit' to quit): ");
                String textmsg = scanner.nextLine();

                // Exit condition
                if ("exit".equalsIgnoreCase(textmsg)) {
                    System.out.println("Exiting chat...");
                    break;
                }

                // Send message to server
                out.println(name + ": " + textmsg);

                // Read server's response
                String response = in.readLine();
                if (response != null) {
                    System.out.println("Server response: " + response);
                } else {
                    System.out.println("No response from server.");
                }
            }
        } finally {
            // Close resources
            scanner.close();
            in.close();
            out.close();
            socket.close();
            System.out.println("Resources closed. Program terminated.");
        }
    }
}

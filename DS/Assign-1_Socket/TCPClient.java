import java.io.*; 
import java.net.*; 
 
public class TCPClient { 
    public static void main(String[] args) { 
        try { 
            Socket socket = new Socket("127.0.0.1", 5000); 
            System.out.println("Connected to server!"); 
 
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); 
            BufferedReader in = new BufferedReader(new 
InputStreamReader(socket.getInputStream())); 
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
 
            String message; 
            while (true) { 
                System.out.print("Enter message: "); 
                message = userInput.readLine(); 
                out.println(message); // send to server 
 
                if (message.equalsIgnoreCase("exit")) { 
                    break; 
                } 
 
                // Read response from server 
                String response = in.readLine(); 
                System.out.println("Server says: " + response); 
            } 
 
            // Close everything 
            userInput.close(); 
            in.close(); 
            out.close(); 
            socket.close(); 
        } catch (IOException e) { 
            System.out.println("Client error: " + e.getMessage()); 
        } 
    } 
} 
import voronin.phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started");

            while (true)
            try (phone phone = new phone(server)) {

                String request = phone.readLine();
                System.out.println("request " + request);
                String response = (int) (Math.random() * 30 - 10) + "";
                phone.writeLine(response);
                System.out.println(response);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

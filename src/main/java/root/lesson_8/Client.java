package root.lesson_8;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST, PORT);

        //msg broker
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
                while (!client.isClosed()) {
                    String message = reader.readLine();
                    if (Objects.equals("", message)) {

                        out.writeUTF("Good bye!!");
                        out.flush();

                        System.out.println("Client is CLOSED");
                        client.close();
                    } else {
                        out.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("OOPS: ERROR IN CLIENT MSG BROKER");
            }
        }).start();

        //listener for incoming messages
        new Thread(() -> {
            try (DataInputStream in = new DataInputStream(client.getInputStream())) {
                while (!client.isClosed()) {
                    if (in.available() > 0) {
                        String message = in.readUTF();
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("OOPS: ERROR IN CLIENT LISTENER");
            }
        }).start();
        System.out.println("Client is READY");
    }
}

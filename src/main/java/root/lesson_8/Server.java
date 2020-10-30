package root.lesson_8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

import static java.net.InetAddress.getByName;

public class Server {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static int count = -1;

    private static final Queue<String> MESSAGES = new ConcurrentLinkedQueue<>();
    private static final Map<Client, DataOutputStream> USERS = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT, 0, getByName(HOST))) {
            System.out.println("Server is READY");

            //receiver
            new Thread(() -> {
                while (!server.isClosed()) {
                    final CommandExecutor commands = new CommandExecutor();

                    if (!MESSAGES.isEmpty()) {
                        final String message = MESSAGES.poll();
                        USERS.forEach((client, out) -> {
                            try {
                                //execute command
                                if (message.startsWith("/") && client.getMessages().contains(message)) {
                                    out.writeUTF(commands.execute(client, message));
                                }
                                //receive message
                                else if (!message.startsWith("/") && !client.getMessages().contains(message)) {
                                    out.writeUTF(message);
                                }
                            } catch (IOException e) {
                                System.err.println("OOPS: ERROR IN RECEIVER");
                            }
                        });
                    }
                }
            }).start();

            while (!server.isClosed()) {
                Socket accept = server.accept();

                Client newClient = new Client("Client " + ++count, new ArrayList<>());
                USERS.put(newClient, new DataOutputStream(accept.getOutputStream()));

                //listener
                new Thread(() -> {
                    try (DataInputStream in = new DataInputStream(accept.getInputStream())) {
                        while (accept.isConnected()) {
                            if (in.available() > 0) {
                                String message = in.readUTF();

                                newClient.getMessages().add(message);
                                USERS.put(newClient, USERS.get(newClient));

                                MESSAGES.add(message);
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("OOPS: ERROR IN LISTENER");
                    }
                }
                ).start();
            }
        } catch (IOException e) {
            System.out.println("Server is CLOSED");
        }
    }

    public static class CommandExecutor {

        private final Map<String, Function<Client, String>> COMMANDS = new HashMap<>();

        {
            COMMANDS.put("/list", (client) -> COMMANDS.keySet().toString());
            COMMANDS.put("/msg", (client) -> USERS.keySet().stream()
                    .filter(aClient -> Objects.equals(aClient, client))
                    .findAny()
                    .map(xClient -> xClient.getMessages().toString())
                    .orElse("empty list")
            );
            COMMANDS.put("/clean", (client) -> USERS.keySet().stream()
                    .filter(aClient -> Objects.equals(aClient, client))
                    .findAny()
                    .map(xClient -> {
                        xClient.getMessages().clear();
                        return "success";
                    })
                    .orElse("fail"));
        }

        public String execute(Client client, String command) {
            if (!COMMANDS.containsKey(command)) {
                return "unknown command";
            }
            return COMMANDS.get(command).apply(client);
        }
    }

    public static class Client implements Serializable {

        private String id;
        private List<String> messages;

        public Client(String id, List<String> messages) {
            this.id = id;
            this.messages = messages;
        }

        public Client() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getMessages() {
            return messages;
        }

        public void setMessages(List<String> messages) {
            this.messages = messages;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Client client = (Client) o;
            return Objects.equals(id, client.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
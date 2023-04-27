import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final ObjectOutputStream output;
    private final ObjectInputStream input;
    private final Socket client;

    public ClientHandler(ObjectOutputStream output, ObjectInputStream input, Socket client) {
        this.output = output;
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = (Message) input.readObject();
                if (message.getNumber() == 0 || message.getContent().equals("exit")) {
                    System.out.println("Zamykanie polaczenia z " + client.toString());
                    client.close();
                    break;
                }
                output.writeObject(message + "");
                System.out.println(message);
            }
            catch (IOException | ClassNotFoundException ex) {
                System.err.println(ex);
            }
        }
    }
}

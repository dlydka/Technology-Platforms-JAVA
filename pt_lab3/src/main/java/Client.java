import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IIOException {
        try (Socket client = new Socket("localhost", 9797)) {
            Scanner scanner = new Scanner(System.in);
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            int messageAmount = Integer.parseInt(scanner.nextLine());
            int messageId = 1;
            while (true) {
                if (messageAmount <= 0) {
                    output.writeObject(new Message(0, "exit"));
                    client.close();
                    break;
                }
                System.out.println("Podaj wiadomosc: ");
                String s = scanner.nextLine();
                if (s.equals("exit")) {
                    output.writeObject(new Message(0, "exit"));
                    client.close();
                    break;
                }
                Message message = new Message(messageId, s);
                output.writeObject(message);
                messageId++;
                messageAmount--;
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}

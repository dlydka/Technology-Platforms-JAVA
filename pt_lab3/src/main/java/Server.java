import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9797)) {
            System.out.println("Serwer został uruchomiony!");
            while (true) {
                Socket client = null;
                try {
                    client = server.accept();
                    System.out.println("Polaczyl sie klient: " + client);
                    ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                    Thread t = new ClientHandler(output, input, client);
                    t.start();
                }
                catch (IOException ex) {
                    assert client != null;
                    client.close();
                    System.err.println(ex);
                }
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

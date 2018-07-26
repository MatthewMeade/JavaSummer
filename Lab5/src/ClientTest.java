import javax.swing.*;

public class ClientTest {
    public static void main(String[] args) {
        Client application = new Client(args.length == 0 ? "127.0.0.1" : args[0]);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient();
    }
}

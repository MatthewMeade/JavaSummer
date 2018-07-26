import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Server extends JFrame {

    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    private int counter = 1;
    private static final String[] GAME_RESPONSES = new String[]{"Rock", "Paper", "Scissors"};


    public Server() {
        super("Server");

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea));

        setSize(300, 600);
        setVisible(true);
    }

    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);
            while (true) {
                try {
                    waitForConnection();
                } catch (EOFException e) {
                    displayMessage("\nServer Terminated Connection");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        Socket connection =  server.accept();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("New Thread!");
                try {
                    ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();

                    ObjectInputStream input = new ObjectInputStream(connection.getInputStream());

                    processConnection(output, input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        displayMessage("Connection " + counter + " recieved from: " + connection.getInetAddress().getHostName());
    }


    private void processConnection(ObjectOutputStream output, ObjectInputStream input) throws IOException {
        String message = "Connection Successful\n";
        sendData(message, output);

        setTextFieldEditable(true);

        do {
            try {
                message = (String) input.readObject();

                displayMessage("\n" + message);
                playGame(message, output    );
            } catch (ClassNotFoundException e) {
                displayMessage("\nUnknown object type received");
            }
        } while (!message.equals("CLIENT>>> TERMINATE"));

    }

    private void closeConnection(ObjectOutputStream output, ObjectInputStream input, Socket connection) {
        displayMessage("\nTerminating Connection");
        setTextFieldEditable(false);

        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendData(String message, ObjectOutputStream output) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException e) {
            displayArea.append("\nError writing object");
        }
    }

    private void displayMessage(final String s) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayArea.append(s);
            }
        });
    }

    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                enterField.setEditable(editable);
            }
        });
    }

    private void playGame(String message, ObjectOutputStream output) {
        if (message.equals("CLIENT>>> Rock") ||
            message.equals("CLIENT>>> Paper") ||
            message.equals("CLIENT>>> Scissors")) {
                sendData(GAME_RESPONSES[new Random().nextInt(GAME_RESPONSES.length)], output);
        }
    }
}






































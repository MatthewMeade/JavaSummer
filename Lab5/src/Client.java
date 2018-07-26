import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;


public class Client extends JFrame {

    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String chatServer;
    private Socket client;

    private JButton[] btns = new JButton[3];
    private JButton closeBtn;

    private String lastPicked = "";


    public Client(String host) {
        super("Client");

        chatServer = host;

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(0, 3));

        String[] btnNames = new String[]{"Rock", "Paper", "Scissors"};

        for (int i = 0; i < btnNames.length; i++) {
            final String msg = btnNames[i];

            btns[i] = new JButton(msg);
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sendData(msg);
                    lastPicked = msg;
                }
            });
            topPanel.add(btns[i]);
        }
        add(topPanel, BorderLayout.NORTH);

        closeBtn = new JButton("Close Connection");
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeConnection();
            }
        });
        add(closeBtn, BorderLayout.SOUTH);


        displayArea = new JTextArea();
        add(new JScrollPane(displayArea));

        setSize(300, 600);
        setVisible(true);
    }

    public void runClient() {
        try {
            connectToServer();
            getStreams();
            processConnection();
        } catch (EOFException e) {
            displayMessage("\nClient Terminated Connection");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void connectToServer() throws IOException {
        displayMessage("Attempting Connection\n");
        client = new Socket(InetAddress.getByName(chatServer), 12345);
        displayMessage("Connected to " + client.getInetAddress().getHostName());
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();

        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    private void processConnection() throws IOException {
        setButonsClickable(true);

        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n" + message);
                judgeGame(message);
            } catch (ClassNotFoundException e) {
                displayMessage("\nUnknown object type received");
            } catch (SocketException e) {
                displayMessage("\nSocket Closed");
                return;
            }
        } while (!message.equals("SERVER>>> TERMINATE"));

    }

    private void judgeGame(String serverMsg) {

        String serverPick = serverMsg.split("SERVER>>> ")[1];
        if (!serverPick.equals("Rock") && !serverPick.equals("Paper") && !serverPick.equals("Scissors")) {
            return;
        }

        if (serverPick.equals(lastPicked)) {
            displayMessage("\nDRAW!\n");
        } else if (lastPicked.equals("Rock") && serverPick.equals("Scissors") ||
                lastPicked.equals("Paper") && serverPick.equals("Rock") ||
                lastPicked.equals("Scissors") && serverPick.equals("Paper")) {
            displayMessage("\nWIN!\n");
        } else {
            displayMessage("\nLOSE!\n");
        }


    }

    private void closeConnection() {
        displayMessage("\nTerminating Connection");
        setButonsClickable(false);

        try {
            output.close();
            input.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendData(String message) {
        try {
            output.writeObject("CLIENT>>> " + message);
            output.flush();
            displayMessage("\nCLIENT>>> " + message);
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

    private void setButonsClickable(final boolean clickable) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < btns.length; i++) {
                    btns[i].setEnabled(clickable);
                }
                closeBtn.setEnabled(clickable);
            }
        });
    }
}






































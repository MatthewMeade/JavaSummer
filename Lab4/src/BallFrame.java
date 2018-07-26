import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BallFrame extends JFrame implements KeyListener {
    public BallFrame() throws HeadlessException {
        super("Ball Frame");
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Random random = new Random();
        Ball newBall = new Ball(random.nextBoolean() ? "red" : "blue", random.nextInt(3) + 1, random.nextInt(3) + 1);
        add(newBall);
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(newBall);
        threadExecutor.shutdown();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Ball ball1 = new Ball("red", 3, 2);
//        Ball ball2 = new Ball("blue", 3, 2);
//        JFrame f = new JFrame();
        BallFrame f = new BallFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);

//        new Thread(ball2).start();
//        new Thread(ball1).start();

//        ExecutorService threadExecutor = Executors.newCachedThreadPool();
//        threadExecutor.execute(ball1);
//        threadExecutor.execute(ball2);
//        threadExecutor.shutdown();

    }


}

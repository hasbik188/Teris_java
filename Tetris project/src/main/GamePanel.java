package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;
    public GamePanel() {

        //PanelSettings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        // Implement KeyListener
        this.addKeyListener(new KeyHandle());
        this.setFocusable(true);

        pm = new PlayManager();
    }
    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game Loop
        float drawInterval = (float) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    private void update() {
        if (KeyHandle.pausePressed == false && pm.gameOver == false) {
            pm.update();
        } else if (KeyHandle.pausePressed == false && pm.gameOver == true) {
            try {
                // Introduce a delay of 5 seconds (5000 milliseconds)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Reset game parameters
            pm.lines = 0;
            pm.score = 0;
            pm.level = 1;
            PlayManager.staticBlocks.clear();
            pm.gameOver = false;
            pm.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
    }
}

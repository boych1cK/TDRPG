package gameCycle;

import Maps.mainMap;
import Maps.tilesets.tileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class gameCycle extends JPanel implements Runnable {

    public final int tileSize = 48;
    final int scale = 1;
    public int maxcol = 15;
    public int maxrow = 15;
    final int width = tileSize*maxcol;
    final int height = tileSize*maxrow;

    int fps = 60;

    int playerX = 100;
    int playerY = 100;
    int playerspeed = 5;

    public mainMap mm = new mainMap("src/Maps/mapfiles/mainmap");

    Thread gameThread;

    tileManager tm = new tileManager(this);

    keyHandler keyHandler = new keyHandler();

    public gameCycle() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double interval = 1000000000 /fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long curr;
        long timer = 0;
        int drawCount = 0;
        while (gameThread !=null){
            curr = System.nanoTime();
            timer += (curr - lastTime);
            delta += (curr - lastTime) / interval;
            lastTime = curr;
            if(delta >= 1){
                update();
                repaint();
                delta --;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update(){
        if(keyHandler.up){
            playerY -= playerspeed;
        }
        if(keyHandler.down){
            playerY += playerspeed;
        }
        if(keyHandler.left){
            playerX -= playerspeed;
        }
        if(keyHandler.right){
            playerX += playerspeed;
        }


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        tm.draw(g2d);

        g2d.fillRect(playerX, playerY, tileSize, tileSize);

    }
}

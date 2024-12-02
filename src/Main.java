import Maps.mainMap;
import gameCycle.gameCycle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Main {
    mainMap map = new mainMap("src/Maps/mapfiles/mainmap");
    Thread gameThread;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GG");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameCycle gc = new gameCycle();
        frame.add(gc);
        frame.pack();
        frame.setVisible(true);
        gc.startGameThread();
    }





}
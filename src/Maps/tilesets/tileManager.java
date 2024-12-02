package Maps.tilesets;
import gameCycle.gameCycle;

import javax.imageio.ImageIO;
import java.awt.*;

public class tileManager {
    gameCycle gc;
    tile[] tile;

    public tileManager(gameCycle gc) {
        this.gc = gc;

        tile = new tile[3];

        getTileImage();
    }

    public void getTileImage() {
        try{
            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("1.png"));
            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("2.png"));
            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("3.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gc.maxcol && row < gc.maxrow)
        {
            g2.drawImage(tile[gc.mm.tileSet[row][col]-1].image,x,y, gc.tileSize, gc.tileSize, null);
            col++;
            x+=gc.tileSize;
            if(col == gc.maxcol)
            {
                col=0;
                x=0;
                row++;
                y+=gc.tileSize;
            }
        }

    }
}

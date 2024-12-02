package Maps;

import java.io.*;
import java.util.Scanner;

public class mainMap {


    public int[][] tileSet = new int[15][15];
    public mainMap(String path) {
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for(int i=0; i<line.length(); i++)
                {
                    tileSet[count][i] = (int) line.charAt(i) - '0';
                    //System.out.print(tileSet[count][i]);
                }
                //System.out.print("\n");
                count++;
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

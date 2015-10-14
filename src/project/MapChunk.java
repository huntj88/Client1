package project;

import project.object.Object;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by James on 10/13/2015.
 */
public class MapChunk implements Runnable{

    int chunkX,chunkY;
    Object[][] mapChunk = new Object[32][32];
    boolean readyToDraw=false;

    int xOffset, yOffset;

    public MapChunk(int chunkX,int chunkY,int xOffset,int yOffset)
    {
        this.chunkX=chunkX;
        this.chunkY=chunkY;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        new Thread(this).start();
    }

    public void buildChunk()
    {
        //Object[][] mapChunk = new Object[32][32];
        String name = getFileName();
        try {
            Scanner scanY = new Scanner(new File(name));
            int y=0;
            while (scanY.hasNextLine())
            {
                Scanner scanX = new Scanner(scanY.nextLine());
                scanX.useDelimiter("-");
                int x=0;
                while (scanX.hasNextInt())
                {
                    mapChunk[x][y] = getType(scanX.next().charAt(0),x,y);
                    x++;
                }
                y++;
                scanX.close();
            }



            scanY.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFileName()
    {
        String name="res/";
        if(chunkX>0)
        {
            name+="p"+chunkX;
        }
        else
        {
            name+="n"+Math.abs(chunkX);
        }

        if(chunkY>0)
        {
            name+="p"+chunkY;
        }
        else
        {
            name+="n"+Math.abs(chunkY);
        }

        name+=".txt";

        System.out.println(name+" has been loaded");

        return name;
    }

    public Object getType(char letter,int x, int y)
    {
        if(chunkX>0&&chunkY>0)
            return new Object(x*64+xOffset,y*64+yOffset-chunkY*32*64,60);
        if(chunkX<0&&chunkY>0)
            return new Object(x*64+xOffset+chunkX*32*64,y*64+yOffset-chunkY*32*64,60);
        if (chunkX>0&&chunkY<0)
            return new Object(x*64+xOffset,y*64+yOffset,60);
        if(chunkX<0&&chunkY<0)
            return new Object(x*64+xOffset+chunkX*32*64,y*64+yOffset,60);

        return null;
        /*switch (letter)
        {
            case 0:
            return new Object()
            break;
        }*/
    }

    public void draw(Graphics g)
    {
        if(readyToDraw) {
            for (int x = 0; x < mapChunk.length; x++) {
                for (int y = 0; y < mapChunk[0].length; y++) {
                    mapChunk[x][y].draw(g);
                }
            }
        }
        //System.out.println(mapChunk);
    }

    @Override
    public void run() {
        buildChunk();
        readyToDraw=true;
    }
}

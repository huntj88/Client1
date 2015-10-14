package project;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by James on 10/14/2015.
 */
public class Map {

    ArrayList<MapChunk> mapChunks = new ArrayList<>();

    private int xDisplace,yDisplace;

    public Map(int xDisplace,int yDisplace)
    {
        this.xDisplace=xDisplace;
        this.yDisplace=yDisplace;
        mapChunks.add(new MapChunk(1,1,xDisplace,yDisplace));
        mapChunks.add(new MapChunk(-1,1,xDisplace,yDisplace));
        mapChunks.add(new MapChunk(-1,-1,xDisplace,yDisplace));
        mapChunks.add(new MapChunk(1,-1,xDisplace,yDisplace));
    }

    public void draw(Graphics g)
    {
        for(int i=0;i<mapChunks.size();i++)
        {
            mapChunks.get(i).draw(g);
        }
    }
}

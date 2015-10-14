package project;

import java.awt.*;

/**
 * Created by James on 10/14/2015.
 */
public class MainPlayer extends Player {

    private int displayX,displayY;

    public MainPlayer(int x, int y, String username,int displayX,int displayY) {
        super(x, y, username);
        this.displayX=displayX;
        this.displayY=displayY;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(displayX - 10, displayY - 10, 20, 20);
    }

    public int getDisplaceX()
    {
        return displayX;
    }

    public int getDisplaceY()
    {
        return displayY;
    }
}

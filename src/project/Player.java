package project;

import java.awt.*;

/**
 * Created by James on 10/13/2015.
 */
public class Player {

    protected int x,y;
    protected String username;

    public Player(int x, int y, String username)
    {
        this.x=x;
        this.y=y;
        this.username=username;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x - 10, y - 10, 20, 20);
    }
}

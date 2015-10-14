package project.object;

import java.awt.*;

/**
 * Created by James on 10/13/2015.
 */
public class Object {

    private int x,y;
    private int size;

    public Object(int x,int y,int size)
    {
        this.x=x;
        this.y=y;
        this.size=size;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(x,y,size,size);
    }
}

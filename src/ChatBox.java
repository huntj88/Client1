import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by James on 10/13/2015.
 */
public class ChatBox  {

    private static final LinkedList<String> chat = new LinkedList<>();



    public ChatBox()
    {
    }

    public static synchronized void addText(String text)
    {
        chat.add(text);
    }

    public synchronized void draw(Graphics g,int x, int y, int height)
    {
        int yDisplace = 0;
        g.setColor(Color.white);
        Iterator<String> itr = chat.descendingIterator();
        while(itr.hasNext()){
            if(yDisplace>height)
                break;
            g.drawString(itr.next(),x,y+height-yDisplace);
            yDisplace+=15;
        }
    }
}

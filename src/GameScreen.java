import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by James on 10/13/2015.
 */
public class GameScreen extends JPanel implements Runnable,KeyListener{

    //protected JTextField textField;
    //protected JTextArea textArea;
    private final static String newline = "\n";
    PacketList outPackets,inPackets;
    private boolean keyboardType=false;
    private String typedString = "";
    private ChatBox chatBox=new ChatBox();

    public GameScreen(PacketList outPackets,PacketList inPackets)
    {
        super();
        this.outPackets=outPackets;
        this.inPackets=inPackets;
        addKeyListener(this);
        new Thread(this).start();
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(0, 0, getWidth(), getHeight());

        if(keyboardType)
        {
            chatBox.draw(g,10,getHeight()-340,300);
            g.setColor(Color.white);
            g.drawRect(0, getHeight() - 30, getWidth() - 1, 29);
            g.drawString(typedString,10,getHeight()-10);
        }
        else
            chatBox.draw(g,10,getHeight()-140,100);
    }

    @Override
    public void run() {

        while(true)
        {
            //System.out.println(keyboardType);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(keyboardType)
        {
            if(e.getKeyChar()!='\b')
                typedString+=e.getKeyChar();
            else
                typedString = typedString.substring(0, typedString.length() - 1);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("hello");
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(keyboardType)
            {
                outPackets.add(new TextPacket(Start.username,Start.username+": "+typedString));
                typedString="";
            }
            keyboardType=!keyboardType;
        }
    }
}

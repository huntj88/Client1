import javax.swing.*;
import java.awt.event.WindowEvent;

/**
 * Created by James on 10/13/2015.
 */
public class CustomFrame extends JFrame {

    PacketList outPackets;

    public CustomFrame(String string,PacketList outPackets)
    {
        super(string);
        this.outPackets=outPackets;
    }

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            outPackets.add(new LogoutPacket(Start.username));
            System.exit(0);
        }
    }
}

/**
 * Created by James on 10/13/2015.
 */
public class LogoutPacket extends Packet {

    private static final long serialVersionUID = 2142633872L;

    public LogoutPacket(String username) {
        super(username);
        packetID=2;
    }

    @Override
    public void doPacket()
    {
        //logout go here
        //gui.addText(username + " has logged out");
        ChatBox.addText(username+" has logged out");
        //remove the player name from list of people so you dont see them anymore?
    }
}

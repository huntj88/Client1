package project.packet;

/**
 * Created by James on 10/13/2015.
 */
public class LoginPacket extends Packet {

    private static final long serialVersionUID = 2142633872L;

    public LoginPacket(String username) {
        super(username);
        packetID=3;
    }

    @Override
    public void doPacket()
    {

    }
}

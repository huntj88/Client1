package project.packet;


/**
 * Created by James on 10/14/2015.
 */
public abstract class AreaPacket extends Packet {

    private static final long serialVersionUID = 2142633872L;

    public AreaPacket(String username) {
        super(username);
    }
}

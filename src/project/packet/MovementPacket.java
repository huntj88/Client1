package project.packet;


/**
 * Created by James on 10/14/2015.
 */
public class MovementPacket extends AreaPacket{

    private static final long serialVersionUID = 2142633872L;

    private int newX,newY;

    public MovementPacket(String username,int newX,int newY) {
        super(username);
        this.newX=newX;
        this.newY=newY;
        packetID=4;
    }

    @Override
    public void doPacket()
    {

    }
}

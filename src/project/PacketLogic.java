package project;

/**
 * Created by James on 10/13/2015.
 */
public class PacketLogic implements Runnable {

    GameScreen gui;
    PacketList inPackets;

    public PacketLogic(GameScreen gui,PacketList inPackets)
    {
        this.gui=gui;
        this.inPackets=inPackets;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true)
        {
            if(inPackets.size()>0)
            {
                inPackets.get().doPacket();
                inPackets.remove();
            }
            else
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

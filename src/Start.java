import javax.swing.*;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by James on 10/13/2015.
 */
public class Start {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 500;
    public static final String username = "huntj88";
    GameScreen gui;

    public static void main(String[] cows)
    {
        /*PacketList packets = new PacketList();
        gui = new GUI(packets);
        setUpGui(packets);*/
        try {
            new Start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Start() throws Exception
    {
        DatagramSocket clientSocket = new DatagramSocket();
        System.out.println(clientSocket.getLocalPort());
        InetAddress IPAddress = InetAddress.getByName("localhost");
        PacketList outPackets = new PacketList();
        PacketList inPackets = new PacketList();
        OutgoingPackets outgoingPackets = new OutgoingPackets(outPackets,clientSocket,IPAddress);
        IncomingPackets incomingPackets = new IncomingPackets(inPackets,clientSocket,IPAddress);
        gui = new GameScreen(outPackets,inPackets);
        PacketLogic packetLogic = new PacketLogic(gui,inPackets);
        setUpGui(gui,outPackets);
    }

    public void setUpGui(GameScreen gui,PacketList outPackets)
    {
        CustomFrame frame = new CustomFrame("Server",outPackets);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //GUI gui = new GUI(packets);
        frame.getContentPane().add(gui);
        frame.setSize(WIDTH,HEIGHT);
        frame.setVisible(true);
    }
}

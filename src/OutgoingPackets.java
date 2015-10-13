import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by James on 10/12/2015.
 */
public class OutgoingPackets implements Runnable {

    private boolean running = true;
    DatagramSocket clientSocket = null;
    PacketList packets;
    InetAddress ip;

    public OutgoingPackets(PacketList packets, DatagramSocket clientSocket,InetAddress ip) {
        this.packets = packets;
        this.clientSocket = clientSocket;
        this.ip=ip;
        new Thread(this).start();
    }

    public void stopThread() {
        running = false;
        clientSocket.close();
    }

    public void send() {

        System.out.println("send attempt");
        byte[] sendData = serializeManagerPacket(packets.get());
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9876);
        try {
            clientSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("sent");

        packets.remove();
    }

    public byte[] serializeManagerPacket(Packet mp) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(mp);
            oos.close();
            // get the byte array of the object
            byte[] obj = baos.toByteArray();
            baos.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void run() {
        while (running) {
            if(packets.size()>0)
                send();
            else
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

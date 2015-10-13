/**
 * Created by James on 10/12/2015.
 */

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        //byte[] receiveData = new byte[1024];
        //String sentence = inFromUser.readLine();
        //Packet packet = new Packet("huntj87");
        TextPacket packet = new TextPacket("huntj88","hey there");
        sendData = serializeManagerPacket(packet);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        //DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //clientSocket.receive(receivePacket);
        //String modifiedSentence = new String(receivePacket.getData());
        //System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }

    public static byte[] serializeManagerPacket(Packet mp)
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(mp);
            oos.close();
            // get the byte array of the object
            byte[] obj= baos.toByteArray();
            baos.close();
            return obj;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}

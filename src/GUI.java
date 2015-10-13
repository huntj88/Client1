import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by James on 10/13/2015.
 */
public class GUI extends JPanel implements ActionListener{

    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
    String username = "huntj88";
    PacketList outPackets,inPackets;

    public GUI(PacketList outPackets,PacketList inPackets)
    {
        super(new GridBagLayout());
        this.outPackets=outPackets;
        this.inPackets=inPackets;
        textField = new JTextField(20);
        textField.addActionListener(this);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = username+": "+textField.getText();
        //addText(text);
        outPackets.add(new TextPacket(username,text));
        textField.selectAll();
    }

    public void addText(String text)
    {
        textArea.append(text+newline);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}

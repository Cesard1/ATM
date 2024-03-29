package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Cambia tu pin");
        text.setBounds(250, 290, 500, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("Nuevo pin:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Repite tu pin:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("Cambiar");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this); // Agregado para activar actionPerformed
        image.add(change);

        back = new JButton("Atras");
        back.setBounds(355, 520, 150, 30);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                char[] npinChars = pin.getPassword();
                char[] rpinChars = repin.getPassword();
                String npin = new String(npinChars);
                String rpin = new String(rpinChars);

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "El pin ingresado no coincide");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese su Pin");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese nuevamente su pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin='" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin='" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin='" + pinnumber + "'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin cambiado exitosamente");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}

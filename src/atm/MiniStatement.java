package atm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    JLabel text, bank, card, balance;
    
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        
        setLayout(null);
        
        text = new JLabel();
        text.setBounds(20, 140, 400, 200);
        add(text);
        
        bank = new JLabel("Banco Méxicano");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try {           
            Conn c5 = new Conn();
            ResultSet rs = c5.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            
            while (rs.next()) {
                card.setText("Numero de tarjeta: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {           
            Conn c5 = new Conn();  
            int bal = 0;
            ResultSet rs = c5.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
            } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                    }
                balance.setText("El dinero en su cuenta actual es de MXN " +  bal);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        // Crear una instancia de MiniStatement con un PIN específico (por ejemplo, "2402")
        new MiniStatement("2402");
    }
}


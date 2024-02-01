package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastchas,ministatement,pinchange,Balanceenquiry,exit;
    String pinnumber;    
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Selecciona el monto de tu retiro");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("MXN 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("MXN 200");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastchas = new JButton("MXN 500");
        fastchas.setBounds(170, 450, 150, 30);
        fastchas.addActionListener(this);
        image.add(fastchas);
       
        ministatement = new JButton("MXN 1000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("MXN 2000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        Balanceenquiry = new JButton("MXN 5000");
        Balanceenquiry.setBounds(355, 485, 150, 30);
        Balanceenquiry.addActionListener(this);
        image.add(Balanceenquiry);
        
        exit = new JButton("Atras");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
                
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
       
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
           String amount = ((JButton)ae.getSource()).getText().substring(3).trim(); //mxn
           Conn c = new Conn();
           try {
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               int balance = 0;
               while (rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));                      
                   } else if (rs.getString("type").equals("Withdrawal")){
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null, "El dinero en su cuenta es insuficiente");
                   return;
               }
               
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "MXN"+ amount + " Retirado exitosamente");
               
               setVisible(true);
               new Transactions(pinnumber).setVisible(true);
               
           } catch (Exception e)  {
               System.out.println(e);
           }
        }
    }
    
    public static void main(String args[]){
        new FastCash("").setVisible(true);
    } 
}

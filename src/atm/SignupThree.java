package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JLabel l1,type,card,number,pin,pnumber,details,pdetails,service,inf;
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancelar;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    ButtonGroup groupgender;
            
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        l1 = new JLabel("Pagina 3: Detalles de la cuenta");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        type = new JLabel("Tipo de cuenta");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Guardar cuenta");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Cuenta de deposito fijo");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Cuenta actual");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Cuenta de deposito recurrente");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        setLayout(null);
        
        r1.setBounds(100,180,150,30);
        add(r1);
        
        r2.setBounds(350,180,300,30);
        add(r2);
        
        r3.setBounds(100,220,150,30);
        add(r3);
        
        r4.setBounds(350,220,300,30);
        add(r4);
        
        card = new JLabel("Numero de tajeta");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        number = new JLabel("XXXX-XXXX-XXXX-0508");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 250, 30);
        add(number);
        
        details = new JLabel("16 digitos de tu tarjeta");
        details.setFont(new Font("Raleway", Font.BOLD, 12));
        details.setBounds(100, 330, 250, 20);
        add(details);
        
        inf= new JLabel("Aparecerá en la tarjeta de cajero automático y en los estados de cuenta.");
        inf.setFont(new Font("Raleway", Font.BOLD, 12));
        inf.setBounds(330, 330, 400, 20);
        add(inf);
        
        pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 250, 30);
        add(pin);
        
        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 250, 30);
        add(pnumber);
        
        pdetails = new JLabel("4 digitos de tu pin");
        pdetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetails.setBounds(100, 400, 300, 20);
        add(pdetails);  
        
        service = new JLabel("Servicios requeridos:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 400, 30);
        add(service);
        
        c1 = new JCheckBox("Tarjeta ATM");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Banca por internet");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Banca por movil");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Alertas por EMAIL y SMS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 300, 30);
        add(c4);
        
        c5 = new JCheckBox("Chequera");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("Declaracion");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("Por la presente declaro que los datos ingresados ​​anteriormente son correctos a mi leal saber y entender.", true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 650, 30);
        add(c7);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBackground(Color.BLACK);
        cancelar.setForeground(Color.WHITE);
        cancelar.setFont(new Font("Raleway", Font.BOLD, 14));
        cancelar.setBounds(250, 720, 100, 30);
        cancelar.addActionListener(this);
        add(cancelar);
        
        submit = new JButton("Enviar");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
           String accountType = null;
           if (r1.isSelected()){
               accountType = "Guardar cuenta";
           } else if (r2.isSelected()){
               accountType = "Cuenta de deposito fijo";
           } else if (r3.isSelected()){
               accountType = "Cuenta actual";
           } else if (r4.isSelected()){
               accountType = "Cuenta de deposito recurrente";
        }
           
            Random random = new Random();
           String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
           
           String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
           
           String facility = "";
           if (c1.isSelected()){
               facility = facility + "Tarjeta ATM";
           } else if (c2.isSelected()){
               facility = facility + "Banca por internet";
           } else if (c3.isSelected()){
               facility = facility + "Banca por movil";
           } else if (c4.isSelected()){
               facility = facility + "Alertas por EMAIL y SMS";
           } else if (c5.isSelected()){
               facility = facility + "Chequera";
           } else if (c6.isSelected()){
               facility = facility + "Declaracion";
           }
           
           try {
               if (accountType.equals("")) {
                   JOptionPane.showMessageDialog(null, "El tipo de cuenta es requerido");
               } else {
                   Conn conn = new Conn();
                   String query1 = "Insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                   String query2 = "Insert into login values('"+formno+"',  '"+cardnumber+"', '"+pinnumber+"')";
                   
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber+ "\nPin: " + pinnumber);
                   
                   setVisible(false);
                   new Deposit (pinnumber).setVisible(false);
               }
           } catch (Exception e) {
               System.out.println(e);
           }
           
        } else if (ae.getSource() == cancelar){
            setVisible(false);
            new Login().setVisible(true);
        }     
    }
    
    public static void main(String args[]) {
        new SignupThree("").setVisible(true);
    }    
}

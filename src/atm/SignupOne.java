package atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
     long random;
     JTextField nameTextField, fnameTextField, dobTextField, emailTextField, adressTextField, cityTextField, stateTextField, pinTextField;
     JButton next;
     JRadioButton male, famale, other, married, unmarried;
     JDateChooser dateChooser;
     SignupOne(){
         
         setLayout(null);
         
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 100L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Fathers name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Fecha de Nacimiento:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Genero:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("hombre");
        male.setBounds(300, 290, 70, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        famale = new JRadioButton("mujer");
        famale.setBounds(450, 290, 60, 30);
        famale.setBackground(Color.WHITE);
        add(famale);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(famale);
        
        JLabel email = new JLabel("Emai Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Estado Marital:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("casado");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("soltero");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("otros");
        other.setBounds(630, 390, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other);
        
        JLabel adress = new JLabel("Direccion:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 440, 200, 30);
        add(adress);
        
        adressTextField = new JTextField();
        adressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adressTextField.setBounds(300, 440, 400, 30);
        add(adressTextField);
        
        JLabel city = new JLabel("Ciudad:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("estado:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        
        next = new JButton("Siguiente");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 120, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
     
     public void actionPerformed(ActionEvent ae) {
         String formno = "" + random; //long
         String name = nameTextField.getText(); //setText
         String fname = fnameTextField.getText();
         String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if (male.isSelected()) {
             gender = "male";
         } else if (famale.isSelected()) {
             gender = "famale";
         }
         
         String email = emailTextField.getText();
         String marital = null;
         if (married.isSelected()){
             marital = "Casado";
         } else if (unmarried.isSelected()){
             marital = "Soltero";
         } else if (other.isSelected()){
             marital = "Otro";
         }
         
         String adress = adressTextField.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pinTextField.getText();
         
         
         try{
             if (name.equals("")){
                 JOptionPane.showMessageDialog(null, "El nombre es requerido");
             } else {
                 Conn c = new Conn();
                 String query = "insert into singup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+adress+"', '"+city+"', '"+pin+"', '"+state+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                new SignupTwo(formno).setVisible(true);
             }
         }catch (Exception e){
             System.out.println(e);
         }
     }
     
    public static void main(String args[]){
        new SignupOne();
    }
}
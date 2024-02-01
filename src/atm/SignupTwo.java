package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField pan, nhouse;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, ingreso, titulo, job;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("New  account application form - page 2");

        JLabel additionDetails = new JLabel("Pagina 2: Detalles adicionales");
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290, 80, 400, 30);
        add(additionDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = {"Ateo", "Cristiano", "Testigo de Jehova", "otros"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Categoria:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[] = {"General", "OBC", "SC", "ST", "otros"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Ingresos:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String ingresocategory[] = {"Nulos", "< 1500", "< 5000", "<10000", "arriba de 15000"};
        ingreso = new JComboBox(ingresocategory);
        ingreso.setBounds(300, 240, 400, 30);
        ingreso.setBackground(Color.WHITE);
        add(ingreso);

        JLabel gender = new JLabel("Educacion ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Titulacion:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String educationValues[] = {"no graduado", "Bachillerato tecnico", "Bahillerato general", "Post grado", "Doctorado", "Otros"};
        titulo = new JComboBox(educationValues);
        titulo.setBounds(300, 315, 400, 30);
        titulo.setBackground(Color.WHITE);
        add(titulo);

        JLabel marital = new JLabel("Ocupacion:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String ocupationValues[] = {"desempleado", "Pasante", "Estudiante", "Trabajador", "Retirado", "Otros"};
        job = new JComboBox(ocupationValues);
        job.setBounds(300, 390, 400, 30);
        job.setBackground(Color.WHITE);
        add(job);
        
        JLabel adress = new JLabel("Telefono movil:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 440, 200, 30);
        add(adress);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Numero de casa:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        nhouse = new JTextField();
        nhouse.setFont(new Font("Raleway", Font.BOLD, 14));
        nhouse.setBounds(300, 490, 400, 30);
        add(nhouse);
        
        JLabel state = new JLabel("Jubilado:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Si");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup smarriedgroup = new ButtonGroup();
        smarriedgroup.add(syes);
        smarriedgroup.add(sno);

        JLabel pin = new JLabel("Cuenta existente:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        eyes = new JRadioButton("Si");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emarriedgroup = new ButtonGroup();
        emarriedgroup.add(eyes);
        emarriedgroup.add(eno);

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
        //String formno = "" + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String singreso = (String) ingreso.getSelectedItem();
        String stitulo = (String) titulo.getSelectedItem();
        String sjob = (String) job.getSelectedItem();
        String jub = null;
        if (syes.isSelected()) {
            jub = "Yes";
        } else if (sno.isSelected()) {
            jub = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        } 
        
        String span = pan.getText();
        String snhouse = nhouse.getText();

        try {
                Conn c = new Conn();
                String query = "insert into singuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+singreso+"', '"+stitulo+"', '"+sjob+"', '"+span+"', '"+snhouse+"', '"+jub+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);  
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}

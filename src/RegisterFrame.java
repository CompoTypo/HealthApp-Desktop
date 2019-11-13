import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField firstname, lastname, username, email, mm,dd,yyyy, race, specialty;
    private JPasswordField password, confPassword;
    private JRadioButton patientRadio, doctorRadio, male, female;
    private ButtonGroup accountRadios, sexgroup;
    private JButton register;
    private JLabel label1, label2, label3, label4, label5, label6, label7, slabel, rlabel, speclabel, todo;
    private String accountType;
    private boolean doctor = false;
    private String gender = "";
    private Auth services = new Auth(); 

    RegisterFrame() {
        this.label1 = new JLabel("First name: ");
        this.label2 = new JLabel("Last name: ");
        this.label3 = new JLabel("Username: ");
        this.label4 = new JLabel("Email: ");
        this.label5 = new JLabel("Date of birth (mm,dd,yyyy): ");
        this.label6 = new JLabel("Password: ");
        this.label7 = new JLabel("Confirm password: ");
        this.slabel = new JLabel("Enter sex: ");
        this.rlabel = new JLabel("Enter race: ");
        
        this.firstname = new JTextField("Albert", 15);
        this.lastname = new JTextField("Einstein", 15);
        this.username = new JTextField("Albert12", 20);
        this.email = new JTextField("einstein@gmail.com", 15);
        this.mm = new JTextField("12",3);
        this.dd = new JTextField("21", 3);
        this.yyyy = new JTextField("1776",3);
        this.password = new JPasswordField("Einstein12", 15);
        this.confPassword = new JPasswordField("Einstein12", 15);
        this.race = new JTextField("", 16);
        this.register = new JButton("Register");
        
        this.patientRadio = new JRadioButton("Patient");
        this.doctorRadio = new JRadioButton("Doctor");
        this.male = new JRadioButton("Male");
        this.female = new JRadioButton("Female");
        this.accountRadios = new ButtonGroup();
        this.sexgroup = new ButtonGroup();
        this.accountRadios.add(patientRadio);
        this.accountRadios.add(doctorRadio);
        this.sexgroup.add(male);
        this.sexgroup.add(female);

        this.firstname.addActionListener(this);
        this.lastname.addActionListener(this);
        this.username.addActionListener(this);
        this.email.addActionListener(this);
        this.dd.addActionListener(this);
        this.mm.addActionListener(this);
        this.yyyy.addActionListener(this);
        this.password.addActionListener(this);
        this.confPassword.addActionListener(this);
        this.patientRadio.addActionListener(this);
        this.doctorRadio.addActionListener(this);
        this.male.addActionListener(this);
        this.female.addActionListener(this);
        this.race.addActionListener(this);
        this.register.addActionListener(this);

        this.setTitle("Please enter your registration info");
        this.setLayout(new GridLayout(30, 2));
        this.setLocation(300, 300);
        this.setSize(325, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.add(label1);
        this.add(firstname);
        this.add(label2);
        this.add(lastname);
        this.add(label3);
        this.add(username);
        this.add(label4);
        this.add(email);
        this.add(label5);
        this.add(mm);
        this.add(dd);
        this.add(yyyy);
        this.add(label6);
        this.add(password);
        this.add(label7);
        this.add(confPassword);
        
        this.add(slabel);
        this.add(male);
        this.add(female);
        male.setSelected(true);
        
        this.add(rlabel);
        this.add(race);
        this.add(register);
        
        this.add(patientRadio);
        this.add(doctorRadio);
        patientRadio.setSelected(true);
        this.add(register);

        this.setVisible(true);
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    
    public void actionPerformed(ActionEvent event) {
    	
        if (event.getSource() == patientRadio) {
        	doctor = false;
        } else if (event.getSource() == doctorRadio) {
        	doctor = true;
        } else if(event.getSource()==male) { 
        	gender = "M";
        } else if(event.getSource()==female) {
        	gender = "F";
        }
        
        else if (event.getSource() == register) {
            String f = firstname.getText();
            String l = lastname.getText();
            String u = username.getText();
            String e = email.getText();
            String d = dd.getText();
            String m = mm.getText();
            String y = yyyy.getText();
            String p = new String(password.getPassword());
            String pc = new String(confPassword.getPassword());
            String r = race.getText();
            accountType = doctor ? "Doctor" : "Patient";
            Calendar cal = new GregorianCalendar();
            if (!Pattern.matches("[a-zA-Z]{2,20}", f)) {
                System.out.println("firstname");
            } else if (!Pattern.matches("[a-zA-Z]{2,20}", l)) {
                System.out.println("lastname");
            } else if (!Pattern.matches("[a-zA-Z0-9_]{8,20}", u)) {
                System.out.println("bad uname");
            } else if (!Pattern.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)", e)) {
                System.out.println("Incorrect email");
            } else if (!Pattern.matches("[0-9]{1,2}", d) || !isInteger(d) || (Integer.parseInt(d)>31)) {
                System.out.println("weird day to be born on");
            } else if (!Pattern.matches("[0-9]{1,2}", m) || !isInteger(m) || (Integer.parseInt(m)>12)) {
                System.out.println("weird month to be born on");
            } else if (!Pattern.matches("[0-9]{4}", y) || !isInteger(y) || Integer.parseInt(y) > cal.get(Calendar.YEAR)) {
                System.out.println("weird year to be born in");
            } else if (!Pattern.matches("[a-zA-Z0-9_]{8,}", p) || pc.equals("")|| !pc.matches(p)) {
                System.out.println("Bad password or passwords dont match");
            } else if (!Pattern.matches("[a-zA-Z]{5,10}", r) || r.equals("") || !((r.equals("White") || r.equals("Black") ||r.equals("Asian")))) {
                System.out.println("Does your race have any letters in it?");
            } else {
                cal.set(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d), 0, 0, 0);
            Date dob = cal.getTime();
            String acctType;
            if(doctor) {
              	acctType = "Doctor";
            }else {
               	acctType = "Patient";
            }
            UserData testBoi = new UserData(f, l, u, e, dob, gender, r, acctType);
            services.Register(testBoi, p);
            System.out.println();
            this.dispose();
            new LoginFrame();
            }
        } 
    }
}
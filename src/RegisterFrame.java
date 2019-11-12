import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField firstname, lastname, username, email, mm,dd,yyyy, height, weight, sex, race, specialty;
    private JPasswordField password, confPassword;
    private JRadioButton patientRadio, doctorRadio;
    private ButtonGroup accountRadios;
    private JButton register;
    private JLabel label1, label2, label3, label4, label5, label6, label7, hlabel, wlabel, slabel, rlabel, speclabel, todo;
    private String accountType;
    private boolean doctor = false;
    private Auth services = new Auth(); 

    public static void main(String[] args) {
        new RegisterFrame();
    }

    RegisterFrame() {
        this.label1 = new JLabel("First name: ");
        this.label2 = new JLabel("Last name: ");
        this.label3 = new JLabel("Username: ");
        this.label4 = new JLabel("Email: ");
        this.label5 = new JLabel("Date of birth: ");
        this.label6 = new JLabel("Password: ");
        this.label7 = new JLabel("Confirm password: ");
        this.hlabel = new JLabel("Enter height (inches): ");
        this.wlabel = new JLabel("Enter weight (pounds): ");
        this.slabel = new JLabel("Enter sex: ");
        this.rlabel = new JLabel("Enter race: ");
        
        this.firstname = new JTextField("", 15);
        this.lastname = new JTextField("", 15);
        this.username = new JTextField("", 20);
        this.email = new JTextField("", 15);
        this.mm = new JTextField("mm",3);
        this.dd = new JTextField("dd", 3);
        this.yyyy = new JTextField("yyyy",3);
        this.password = new JPasswordField("", 15);
        this.confPassword = new JPasswordField("", 15);
        
        this.sex = new JTextField("M/F", 16);
        this.race = new JTextField("", 16);
        
        this.register = new JButton("Register");
        this.register.addActionListener(this);
        
        this.patientRadio = new JRadioButton("patient");
        this.doctorRadio = new JRadioButton("doctor");
        this.accountRadios = new ButtonGroup();
        this.accountRadios.add(patientRadio);
        this.accountRadios.add(doctorRadio);

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
        
        this.sex.addActionListener(this);
        this.race.addActionListener(this);

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
        
        this.add(hlabel);
        this.add(height);
        this.add(wlabel);
        this.add(weight);
        this.add(slabel);
        this.add(sex);
        this.add(rlabel);
        this.add(race);
        this.add(register);
        
        this.add(patientRadio);
        this.add(doctorRadio);
        this.add(register);

        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == patientRadio) {
        	doctor = false;
        } else if (event.getSource() == doctorRadio) {
        	doctor = true;
        } else if (event.getSource() == register) {
            String f = firstname.getText();
            String l = lastname.getText();
            String u = username.getText();
            String e = email.getText();
            int d = day.getText().equals("") ? 0 : Integer.parseInt(day.getText());
            int m = month.getText().equals("") ? 0 : Integer.parseInt(month.getText()) - 1;
            int y = year.getText().equals("") ? 0 : Integer.parseInt(year.getText());
            String p = new String(password.getPassword());
            String pc = new String(confPassword.getPassword());
            String s = sex.getText();
            String r = race.getText();
            accountType = doctor ? "Doctor" : "Patient";
            Calendar cal = new GregorianCalendar();

            if (!Pattern.matches("[a-zA-Z]{2,20}", l)) {
                System.out.println("weird year to be born in");
            } else if (!Pattern.matches("[a-zA-Z]{2,20}", l)) {
                System.out.println("Error lastname");
            } else if (!Pattern.matches("[a-zA-Z0-9_]{8,20}", u)) {
                System.out.println("bad uname");
            } else if (!Pattern.matches("^(.+)@(.+)$", e)) {
                System.out.println("Incorrect email");
            } else if (!Pattern.matches("[0-9]{1,2}", Integer.toString(d)) && d <= 32) {
                System.out.println("weird day to be born on");
            } else if (!Pattern.matches("[01][0-9]{1,2}", Integer.toString(m)) && m <= 12) {
                System.out.println("weird month to be born on");
            } else if (!Pattern.matches("[0-9]{4}", Integer.toString(y)) && y <= cal.get(Calendar.YEAR)) {
                System.out.println("weird year to be born in");
            } else if (Pattern.matches("[a-zA-Z0-9_]{8,}", p) && p.matches(pc)) {
                System.out.println("Bad password or passwords dont match");
            } else if (!Pattern.matches("[a-zA-Z]{0,10}", s)) {
                System.out.println("Weird sex");
            } else if (!Pattern.matches("[a-zA-Z]{0,10}", r)) {
                System.out.println("Does your race have any letters in it?");
            } else {
                cal.set(y, m, d, 0, 0, 0);
                Date dob = cal.getTime();
                UserData testBoi = new UserData(f, l, u, e, dob, s, r, this.acctType);
                services.Register(testBoi, p);
                System.out.println();
                this.dispose();
                new LoginFrame();
            
            }
        } 
    }
}
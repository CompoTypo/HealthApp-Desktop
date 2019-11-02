import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private Auth services = new Auth(); 
    private static final long serialVersionUID = 1L;
    private JPasswordField password, confPassword;
    private JRadioButton patientRadio, doctorRadio;
    private ButtonGroup accountRadios;
    private JButton register;
    private String acctType = "";

    private JLabel label1 = new JLabel("First name: ");
    private JLabel label2 = new JLabel("Last name: ");
    private JLabel label3 = new JLabel("Username: ");
    private JLabel label4 = new JLabel("Email: ");
    private JLabel label5 = new JLabel("Date of birth: ");
    private JLabel label6 = new JLabel("Password: ");
    private JLabel label7 = new JLabel("Confirm password: ");
    private JLabel slabel = new JLabel("Enter sex: ");
    private JLabel rlabel = new JLabel("Enter race: ");
    private JLabel speclabel = new JLabel("Enter your specialty: ");
    private JLabel hlabel = new JLabel("Enter height (inches): ");
    private JLabel wlabel = new JLabel("Enter weight (pounds): ");
    private JLabel todo = new JLabel("TODO: ask for credentials to verify");
    
    private JTextField firstname = new JTextField("", 15);
    private JTextField lastname = new JTextField("", 15);
    private JTextField username = new JTextField("", 20);
    private JTextField email = new JTextField("", 15);
    private JTextField day = new JTextField("", 3);
    private JTextField month = new JTextField("", 3);
    private JTextField year = new JTextField("", 6);
    private JTextField sex = new JTextField("", 16);
    private JTextField race = new JTextField("", 16);
    private JTextField height = new JTextField("", 16);
    private JTextField weight = new JTextField("", 16);
    private JTextField specialty = new JTextField("", 15);


    public static void main(String[] args) {
        new RegisterFrame();
    }

    RegisterFrame() {

        this.password = new JPasswordField("", 15);
        this.confPassword = new JPasswordField("", 15);
        this.patientRadio = new JRadioButton("patient");
        this.doctorRadio = new JRadioButton("doctor");

        this.accountRadios = new ButtonGroup();
        this.accountRadios.add(patientRadio);
        this.accountRadios.add(doctorRadio);

        this.firstname.addActionListener(this);
        this.lastname.addActionListener(this);
        this.username.addActionListener(this);
        this.email.addActionListener(this);
        this.day.addActionListener(this);
        this.month.addActionListener(this);
        this.year.addActionListener(this);
        this.password.addActionListener(this);
        this.confPassword.addActionListener(this);
        this.patientRadio.addActionListener(this);
        this.doctorRadio.addActionListener(this);
        this.sex.addActionListener(this);
        this.race.addActionListener(this);
        

        this.setTitle("Please enter your registration info");
        this.setLayout(new FlowLayout());
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
        this.add(day);
        this.add(month);
        this.add(year);
        this.add(label6);
        this.add(password);
        this.add(label7);
        this.add(confPassword);
        this.add(slabel);
        this.add(sex);
        this.add(rlabel);
        this.add(race);
        this.add(patientRadio);
        this.add(doctorRadio);


        this.setVisible(true);
        this.register = new JButton("Register");
        this.register.addActionListener(this);
    }

    private void DoctorForm() {

        this.add(speclabel);
        this.add(specialty);
        this.add(todo);
        this.add(register);
        this.setVisible(true);

    }

    private void PatientForm() {

        this.height.addActionListener(this);
        this.weight.addActionListener(this);
        
        this.add(hlabel);
        this.add(height);
        this.add(wlabel);
        this.add(weight);
        this.add(register);
        this.setVisible(true);
    }

    private void DisposeDoctorForm() {
        this.remove(speclabel);
        this.remove(specialty);
        this.remove(todo);
        this.remove(register);
        this.setVisible(true);

    }

    private void DisposePatientForm() {
        this.remove(hlabel);
        this.remove(height);
        this.remove(wlabel);
        this.remove(weight);
        this.remove(register);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == patientRadio) {
            if (!this.acctType.equals("patient")) { this.DisposeDoctorForm(); }
            this.acctType = "patient";
            this.PatientForm();
        } else if (event.getSource() == doctorRadio) {
            if (!this.acctType.equals("doctor")) { this.DisposePatientForm(); }
            this.acctType = "doctor";
            this.DoctorForm();
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
            Calendar cal = new GregorianCalendar();

            if (!Pattern.matches("[a-zA-Z]{2,20}", l)) {
                System.out.println("weird year to be born in");
            } else if (!Pattern.matches("[a-zA-Z]{2,20}", l)) {
                System.out.println("Error lastname");
            } else if (!Pattern.matches("[a-zA-Z0-9_]{0,20}", u)) {
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
                System.out.println(dob.toString());
                services.Register(testBoi, p);
                System.out.println();
                this.dispose();
                new LoginFrame();
            
            }
        } 
    }
}

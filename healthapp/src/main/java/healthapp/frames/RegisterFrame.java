package healthapp.frames;
import healthapp.utilities.Auth;
import healthapp.utilities.InputValidation;
import healthapp.models.UserData;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private Auth services = new Auth();
    private InputValidation inVal = new InputValidation();

    private static final long serialVersionUID = 1L;
    private JTextField firstname, lastname, username, email, mm, dd, yyyy, race, specialty;
    private JPasswordField password, confPassword;
    private JRadioButton patientRadio, doctorRadio, male, female;
    private ButtonGroup accountRadios, sexgroup;
    private JButton register;
    private JLabel label1, label2, label3, label4, label5, label6, label7, slabel, rlabel, speclabel, todo;
    private boolean doctor = false;
    private String gender = "";

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
        this.mm = new JTextField("12", 3);
        this.dd = new JTextField("21", 3);
        this.yyyy = new JTextField("1776", 3);
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
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
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
        } else if (event.getSource() == male) {
            gender = "M";
        } else if (event.getSource() == female) {
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
            Calendar cal = new GregorianCalendar();

            if (!inVal.isValidName(f)) {
                System.out.println("firstname");
            } else if (!inVal.isValidName(l)) {
                System.out.println("lastname");
            } else if (!inVal.isValidUN(u)) {
                System.out.println("bad uname");
            } else if (!inVal.isValidEmail(e)) {
                System.out.println("Incorrect email");
            } else if (!inVal.isValidYear(y)) {
                System.out.println("weird day to be born on");
            } else if (!inVal.isValidMonth(m)) {
                System.out.println("weird month to be born on");
            } else if (!inVal.isValidDay(d)) {
                System.out.println("weird year to be born in");
            } else if (!inVal.isValidPW(p)) {
                System.out.println("Bad password");
            } else if (!p.equals(pc)) {
                System.out.println("Passwords dont match");
            } else if (!inVal.isValidRace(r)) {
                System.out.println("Does your race have any letters in it?");
            } else {
                cal.set(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d), 0, 0, 0);
                Date dob = cal.getTime();
                String acctType;
                acctType = doctor ? "Doctor" : "Patient";
                UserData testBoi = new UserData(f, l, u, e, dob, gender, r, acctType);
                services.Register(testBoi, p);
                System.out.println();
                this.dispose();
                new LoginFrame();
            }
        }
    }
}
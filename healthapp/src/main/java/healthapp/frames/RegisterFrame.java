package healthapp.frames;
import healthapp.models.UserData;
import healthapp.utilities.Auth;
import healthapp.utilities.InputValidation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private final Auth services = new Auth();
    private final InputValidation inVal = new InputValidation();

    private static final long serialVersionUID = 1L;
    private final JTextField firstname, lastname, username, email, mm, dd, yyyy, race;
    private final JPasswordField password, confPassword;
    private final JRadioButton patientRadio, doctorRadio, male, female;
    private final ButtonGroup accountRadios, sexgroup;
    private final JButton register;
    private boolean doctor = false;
    private String gender = "";

    /**
     * /** constructor
     * @return nothing
     */
    RegisterFrame() {
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
        this.setLayout(new GridLayout(0, 2));
        this.setLocation(300, 300);
        this.setSize(325, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(new JLabel("First name: "));
        this.add(firstname);
        this.add(new JLabel("Last name: "));
        this.add(lastname);
        this.add(new JLabel("Username: "));
        this.add(username);
        this.add(new JLabel("Email: "));
        this.add(email);
        this.add(new JLabel("Date of birth (mm,dd,yyyy): "));
        this.add(mm);
        this.add(dd);
        this.add(yyyy);
        this.add(new JLabel("Password: "));
        this.add(password);
        this.add(new JLabel("Confirm password: "));
        this.add(confPassword);

        this.add(new JLabel("Enter sex: "));
        this.add(male);
        this.add(female);
        male.setSelected(true);

        this.add(new JLabel("Enter race: "));
        this.add(race);
        this.add(register);

        this.add(patientRadio);
        this.add(doctorRadio);
        patientRadio.setSelected(true);
        this.add(register);

        this.setVisible(true);
    }

    /**
     * /** Method checks is int
     * @param s string of int
     * @return boolean
     */
    public static boolean isInteger(final String s) {
        try {
            Integer.parseInt(s);
        } catch (final NumberFormatException e) {
            return false;
        } catch (final NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * /** Method handles actions
     * @param e action
     * @return nothing
     */
    public void actionPerformed(final ActionEvent event) {

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
            final String f = firstname.getText();
            final String l = lastname.getText();
            final String u = username.getText();
            final String e = email.getText();
            final String d = dd.getText();
            final String m = mm.getText();
            final String y = yyyy.getText();
            final String p = new String(password.getPassword());
            final String pc = new String(confPassword.getPassword());
            final String r = race.getText();
            final Calendar cal = new GregorianCalendar();

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
                final Date dob = cal.getTime();
                String acctType;
                acctType = doctor ? "Doctor" : "Patient";
                final UserData testBoi = new UserData(f, l, u, e, dob, gender, r, acctType);
                services.Register(testBoi, p);
                System.out.println();
                this.dispose();
                new LoginFrame();
            }
        }
    }
}
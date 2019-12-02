import java.awt.FlowLayout;
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
    private JTextField firstname, lastname, username, email, day, month, year, height, weight, sex, race, specialty;
    private JPasswordField password, confPassword;
    private JRadioButton patientRadio, doctorRadio;
    private ButtonGroup accountRadios;
    private JButton register;
    private JLabel label1, label2, label3, label4, label5, label6, label7, hlabel, wlabel, slabel, rlabel, speclabel, todo;
    private String accountType;

    public static void main(String[] args) {
        new RegisterFrame();
    }

    RegisterFrame() {
        label1 = new JLabel("First name: ");
        label2 = new JLabel("Last name: ");
        label3 = new JLabel("Username: ");
        label4 = new JLabel("Email: ");
        label5 = new JLabel("Date of birth: ");
        label6 = new JLabel("Password: ");
        label7 = new JLabel("Confirm password: ");

        firstname = new JTextField("", 15);
        lastname = new JTextField("", 15);
        username = new JTextField("", 20);
        email = new JTextField("", 15);
        day = new JTextField("dd", 3);
        month = new JTextField("mm", 3);
        year = new JTextField("yyyy", 6);
        password = new JPasswordField("", 15);
        confPassword = new JPasswordField("", 15);
        patientRadio = new JRadioButton("patient");
        doctorRadio = new JRadioButton("doctor");
        accountRadios = new ButtonGroup();
        accountRadios.add(patientRadio);
        accountRadios.add(doctorRadio);

        firstname.addActionListener(this);
        lastname.addActionListener(this);
        username.addActionListener(this);
        email.addActionListener(this);
        day.addActionListener(this);
        month.addActionListener(this);
        year.addActionListener(this);
        password.addActionListener(this);
        confPassword.addActionListener(this);
        patientRadio.addActionListener(this);
        doctorRadio.addActionListener(this);

        this.setTitle("Please enter your registration info");
        this.setLayout(new FlowLayout());
        this.setLocation(300, 300);
        setSize(325, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(label1);
        add(firstname);
        add(label2);
        add(lastname);
        add(label3);
        add(username);
        add(label4);
        add(email);
        add(label5);
        add(day);
        add(month);
        add(year);
        add(label6);
        add(password);
        add(label7);
        add(confPassword);
        add(patientRadio);
        add(doctorRadio);

        setVisible(true);
        register = new JButton("Register");
        register.addActionListener(this);
    }

    private void DoctorForm() {
        speclabel = new JLabel("Enter your specialty: ");
        todo = new JLabel("TODO: ask for credentials to verify");
        specialty = new JTextField("", 15);
        add(speclabel);
        add(specialty);
        add(todo);
        add(register);
        setVisible(true);

    }

    private void PatientForm() {
        hlabel = new JLabel("Enter height (inches): ");
        wlabel = new JLabel("Enter weight (pounds): ");
        slabel = new JLabel("Enter sex: ");
        rlabel = new JLabel("Enter race: ");
        height = new JTextField("", 16);
        weight = new JTextField("", 16);
        sex = new JTextField("", 16);
        race = new JTextField("", 16);
        height.addActionListener(this);
        weight.addActionListener(this);
        sex.addActionListener(this);
        race.addActionListener(this);
        
        add(hlabel);
        add(height);
        add(wlabel);
        add(weight);
        add(slabel);
        add(sex);
        add(rlabel);
        add(race);
        add(register);
        setVisible(true);
    }

    private void DisposeDoctorForm() {
        remove(speclabel);
        remove(specialty);
        remove(todo);
        remove(register);
        setVisible(true);

    }

    private void DisposePatientForm() {
        remove(hlabel);
        remove(height);
        remove(wlabel);
        remove(weight);
        remove(slabel);
        remove(sex);
        remove(rlabel);
        remove(race);
        remove(register);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == patientRadio) {
            if (this.accountType == "doctor") { this.DisposeDoctorForm(); }
            accountType = "patient";
            PatientForm();
        } else if (event.getSource() == doctorRadio) {
            if (this.accountType == "patient") { this.DisposePatientForm(); }
            accountType = "doctor";
            DoctorForm();
        } else if (event.getSource() == register) {
            String f = firstname.getText();
            String l = lastname.getText();
            String u = username.getText();
            String e = email.getText();
            String d = day.getText();
            String m = month.getText();
            String y = year.getText();
            String p = password.getPassword().toString();
            String pc = confPassword.getPassword().toString();

            Matcher reg = Pattern.compile("^(.+)@(.+)$").matcher(e);
            System.out.println(reg.matches());

            // Date dob = new Date(y, m, d);

            // Patient testBoi = new Patient(f, l, u, e);
            System.out.println();
            if (accountType.equals("doctor") ) {
                
            } else if (accountType.equals("patient") ) {

            }
            dispose();
            new LoginFrame();
        } 
    }
}

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
        this.label1 = new JLabel("First name: ");
        this.label2 = new JLabel("Last name: ");
        this.label3 = new JLabel("Username: ");
        this.label4 = new JLabel("Email: ");
        this.label5 = new JLabel("Date of birth: ");
        this.label6 = new JLabel("Password: ");
        this.label7 = new JLabel("Confirm password: ");

        this.firstname = new JTextField("", 15);
        this.lastname = new JTextField("", 15);
        this.username = new JTextField("", 20);
        this.email = new JTextField("", 15);
        this.day = new JTextField("dd", 3);
        this.month = new JTextField("mm", 3);
        this.year = new JTextField("yyyy", 6);
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
        this.add(patientRadio);
        this.add(doctorRadio);

        this.setVisible(true);
        this.register = new JButton("Register");
        this.register.addActionListener(this);
    }

    private void DoctorForm() {
        this.speclabel = new JLabel("Enter your specialty: ");
        this.todo = new JLabel("TODO: ask for credentials to verify");
        this.specialty = new JTextField("", 15);
        this.add(speclabel);
        this.add(specialty);
        this.add(todo);
        this.add(register);
        this.setVisible(true);

    }

    private void PatientForm() {
        this.hlabel = new JLabel("Enter height (inches): ");
        this.wlabel = new JLabel("Enter weight (pounds): ");
        this.slabel = new JLabel("Enter sex: ");
        this.rlabel = new JLabel("Enter race: ");
        this.height = new JTextField("", 16);
        this.weight = new JTextField("", 16);
        this.sex = new JTextField("", 16);
        this.race = new JTextField("", 16);
        this.height.addActionListener(this);
        this.weight.addActionListener(this);
        this.sex.addActionListener(this);
        this.race.addActionListener(this);
        
        this.add(hlabel);
        this.add(height);
        this.add(wlabel);
        this.add(weight);
        this.add(slabel);
        this.add(sex);
        this.add(rlabel);
        this.add(race);
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
        this.remove(slabel);
        this.remove(sex);
        this.remove(rlabel);
        this.remove(race);
        this.remove(register);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == patientRadio) {
            if (this.accountType == "doctor") { this.DisposeDoctorForm(); }
            this.accountType = "patient";
            this.PatientForm();
        } else if (event.getSource() == doctorRadio) {
            if (this.accountType == "patient") { this.DisposePatientForm(); }
            this.accountType = "doctor";
            this.DoctorForm();
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
            if (this.accountType.equals("doctor") ) {
                
            } else if (this.accountType.equals("patient") ) {

            }
            this.dispose();
            new LoginFrame();
        } 
    }
}

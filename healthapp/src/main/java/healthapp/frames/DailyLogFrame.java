/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import healthapp.utilities.InputValidation;
import healthapp.utilities.Requests;

import javax.swing.*;

public class DailyLogFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private InputValidation inVal = new InputValidation();

    private JTextField Log1, Log2, Log3, Log4, Log5;
    private JButton setLog;
    private String hash;

    JTextField notifyOutput = new JTextField(16);

    /**
     * /** constructor
     * @param user userdata
     * @return nothing
     */
    public DailyLogFrame(String h, String daynum) {
        this.hash = h;
        Log1 = new JTextField("", 10);
        Log2 = new JTextField("", 3);
        Log3 = new JTextField("", 3);
        Log4 = new JTextField("", 3);
        Log5 = new JTextField("", 3);
        setLog = new JButton("Enter");

        Log1.addActionListener(this);
        Log2.addActionListener(this);
        Log3.addActionListener(this);
        Log4.addActionListener(this);
        Log5.addActionListener(this);
        setLog.addActionListener(this);

        this.setTitle("Enter Your Daily Log");
        this.setLayout(new FlowLayout());
        this.setLocation(300, 300);
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(new JLabel("Day " + daynum));
        add(new JLabel("Weight in pounds    "));
        add(Log1);
        add(new JLabel("Blood Pressure"));
        add(Log2);
        add(new JLabel("/"));
        add(Log3);
        add(new JLabel("Temp"));
        add(Log5);
        add(new JLabel("Pulse"));
        add(Log4);
        add(setLog);

        setVisible(true);
    }

    /**
     * /** Method handles actions
     * @param e action
     * @return nothing
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setLog) {
            String w = Log1.getText();
            String t = Log5.getText();
            String sys = Log2.getText();
            String dia = Log3.getText();
            String pulse = Log4.getText();

            if (!inVal.isValidNumber(w)) {
                System.out.println("invalid weight");
            } else if (!inVal.isValidNumber(sys)) {
                System.out.println("invalid blood pressure");
            } else if (!inVal.isValidNumber(dia)) {
                System.out.println("invalid blood pressure");
            } else if (!inVal.isValidNumber(pulse)) {
                System.out.println("invalid pulse");
            } else {
                Map<String, Object> log = new HashMap<>();
                log.put("Hash", this.hash);
                log.put("Wght", w);
                log.put("Temp", t);
                log.put("RTime", System.currentTimeMillis());
                log.put("Hash", this.hash);
                log.put("Sys", dia);
                log.put("Dia", dia);
                log.put("Pulse", pulse);
                log.put("RTime", System.currentTimeMillis());
                Map <String, String> rawUpdatedUser = Requests.send(log, "POST", "/log");
                this.dispose();
            }
        }
    }
}

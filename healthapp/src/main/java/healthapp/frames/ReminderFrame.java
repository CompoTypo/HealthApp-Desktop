/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import healthapp.utilities.InputValidation;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import healthapp.models.Reminder;

import javax.swing.*;

public class ReminderFrame extends JFrame implements ActionListener{
	
        InputValidation inVal = new InputValidation();
        private static final long serialVersionUID = 1L;
        
        private JLabel titleLabel;
        private JLabel timeLabel;
        private JLabel dateLabel;
        private JLabel descriptionLabel;
        private JTextField ReminderName;
        private JTextField ReminderTime1;
         private JTextField ReminderTime2;
        private JTextField ReminderDescription;
        private JTextField ReminderDate1;
        private JTextField ReminderDate2;
        private JTextField ReminderDate3;
        private JButton setRemind;
	
	JTextField notifyOutput = new JTextField(16);

	ReminderFrame() 
        {
          titleLabel = new JLabel("Reminder Title: ");
          dateLabel = new JLabel("Set Date MM/DD/YYYY: ");
          timeLabel = new JLabel("Set Time H/Min:");
          descriptionLabel = new JLabel("Description:    ");
          
          ReminderName = new JTextField("", 20);
          ReminderDate1 = new JTextField("", 2);
          ReminderDate2 = new JTextField("", 2);
          ReminderDate3 = new JTextField("", 4);
          ReminderTime1 = new JTextField("", 1);
          ReminderTime2 = new JTextField("", 2);
          ReminderDescription = new JTextField("", 100);
          setRemind = new JButton ("Set Reminder");
          
          ReminderName.addActionListener(this);
          ReminderDate1.addActionListener(this);
          ReminderDate2.addActionListener(this);
          ReminderDate3.addActionListener(this);
       	  ReminderTime1.addActionListener(this);
          ReminderTime2.addActionListener(this);
	  ReminderDescription.addActionListener(this);
	  setRemind.addActionListener(this);
          
          this.setTitle("Please Create a New Reminder");
          this.setLayout(new FlowLayout());
	  this.setLocation(300, 300);
	  setSize(350, 300);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
          
          add(titleLabel);
          add(ReminderName);
          add(dateLabel);
          add(ReminderDate1);
          add(ReminderDate2);
          add(ReminderDate3);
          add(timeLabel);
          add(ReminderTime1);
          add(ReminderTime2);
          add(descriptionLabel);
          add(ReminderDescription);     
          add(setRemind);
        
          setVisible(true);
        }



public void actionPerformed(ActionEvent e)
{
   if(e.getSource() == setRemind)
   {
       String title = ReminderName.getText();
       String mon = ReminderDate1.getText();
       String day = ReminderDate2.getText();
       String year = ReminderDate3.getText();
       String hour = ReminderTime1.getText();
       String min = ReminderTime2.getText();
       String des = ReminderDescription.getText();
       
       
       if (!inVal.isValidMonth(mon)) {
                System.out.println("Month");
            } else if (!inVal.isValidDay(day)) {
                System.out.println("Day");
            } else if (!inVal.isValidYear(year)) {
                System.out.println("bad year");
            } else if (!inVal.isValidHour(hour)) {
                System.out.println("Invalid hour");
            } else if (!inVal.isValidMinute(min)) {
                System.out.println("Invalid minute of the hour");
            }
       else
            {
              final Reminder test = new Reminder(title, Integer.parseInt(mon), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(min), des);
            }
   }
}

}



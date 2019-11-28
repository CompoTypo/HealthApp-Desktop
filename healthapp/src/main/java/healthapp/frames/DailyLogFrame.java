/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.frames;

import healthapp.models.DailyLog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import healthapp.utilities.InputValidation;

import javax.swing.*;

public class DailyLogFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
        private InputValidation inVal = new InputValidation();

        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JLabel label4;
        private JTextField Log1;
        private JTextField Log2;
        private JTextField Log3;
        private JButton setLog;
        
        JTextField notifyOutput = new JTextField(16);

	DailyLogFrame() 
        {
          label1 = new JLabel("Weight in pounds ");
          label2 = new JLabel("Blood Pressure");
          label3 = new JLabel("/");
          Log1 = new JTextField("", 10);
          Log2 = new JTextField("", 3);
          Log3 = new JTextField("", 3); 
          setLog = new JButton ("Enter");
          
          Log1.addActionListener(this);
          Log2.addActionListener(this);
          Log3.addActionListener(this);
          
          this.setTitle("Enter Your Daily Log");
          this.setLayout(new FlowLayout());
	  this.setLocation(300, 300);
	  setSize(350, 300);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
          
          add(label1);
          add(Log1);
          add(label2);
          add(Log2);
          add(label3);
          add(Log3);
          add(setLog);
        
          setVisible(true);
        }



public void actionPerformed(ActionEvent e)
{
   if(e.getSource() == setLog)
   {
       String w = Log1.getText();
       String bpO = Log2.getText();
       String bpU = Log3.getText();
           
       if (!inVal.isValidMonth(w)) {
           System.out.println("invalid weight");
       }
       
       else
        {
           final DailyLog test = new DailyLog(Integer.parseInt(w), Integer.parseInt(bpO), Integer.parseInt(bpU));
       }
   }
}

}

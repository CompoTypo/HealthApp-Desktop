import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

// import jdk.javadoc.internal.tool.Main;

public class HomeFrame extends JFrame implements ActionListener{// inheriting JFrame
   private static final long serialVersionUID = 1L;
   private JButton b;
   private static LoginFrame login;
   HomeFrame(Map<String, String> user) {
      b = new JButton("WTG");// create button
      b.addActionListener(this);
      add(b);// adding button on frame
      this.setLayout(new FlowLayout());
  	  setSize(1920,1080);
  	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  setResizable(false);
  	  setVisible(true);
   }
   public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==b) {
		   System.out.println("a");
	   }
   }
}

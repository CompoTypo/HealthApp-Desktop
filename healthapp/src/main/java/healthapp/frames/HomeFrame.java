package healthapp.frames;
import healthapp.models.UserData;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// import jdk.javadoc.internal.tool.Main;

public class HomeFrame extends JFrame implements ActionListener {// inheriting JFrame
   private static final long serialVersionUID = 1L;

   /**
     * /** Constructor
     * @param user userdata
     * @return nothing
     */
   HomeFrame(UserData user) {
      System.out.println(user.getFirstname());
      this.setLayout(new FlowLayout());
      setSize(1920, 1080);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.add(new CalendarTable(user));
      setResizable(false);
      setVisible(true);
   }

   
   public void actionPerformed(ActionEvent e) {
   }
}

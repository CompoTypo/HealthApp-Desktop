import javax.swing.*;
// import java.io.*;
// import java.util.Scanner;
// import java.util.ArrayList;

public class MainFrame extends JFrame {// inheriting JFrame
   JFrame f;
   private static final long serialVersionUID = 1L;

   MainFrame() {
      JButton b = new JButton("click");// create button
      b.setBounds(130, 100, 100, 40);
      add(b);// adding button on frame

      setSize(400, 500);
      setLayout(null);
      setVisible(true);
   }

   public static void main(String[] args) {
      new MainFrame();
   }
}

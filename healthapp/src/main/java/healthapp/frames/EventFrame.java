package healthapp.frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// import jdk.javadoc.internal.tool.Main;

public class EventFrame extends JFrame implements ActionListener {// inheriting JFrame
    private static final long serialVersionUID = 1L;
    private JButton b;

    /**
     * /** constructor
     * @param user userdata
     * @return nothing
     */
    EventFrame() {

        this.setLayout(new GridLayout(0, 2));
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("Submit date");// create button
        b.addActionListener(this);
        add(b);// adding button on frame
        setResizable(false);
        setVisible(true);
    }

    /**
     * /** Method does blah blah blah
     * @param e action
     * @return nothing
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {

        }
    }
}

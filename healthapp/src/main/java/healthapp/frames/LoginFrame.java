package healthapp.frames;
import healthapp.utilities.Auth;
import healthapp.utilities.InputValidation;
import healthapp.frames.RegisterFrame;
import healthapp.models.UserData;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	private	Auth services = new Auth();
	private InputValidation inVal = new InputValidation();

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private JButton login, register;
	
    /**
     * /** constructor
     * @return nothing
     */
	public LoginFrame() {
		username = new JTextField("", 20);
		password = new JPasswordField("", 20);
		login = new JButton("Login");
		register = new JButton("Register");
		username.addActionListener(this);
		password.addActionListener(this);
		login.addActionListener(this);
		register.addActionListener(this);

		this.setTitle("Please enter your login info");
		this.setLayout(new FlowLayout());
		this.setLocation(300, 300);
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		add(new JLabel("Username: "));
		add(username);
		add(new JLabel("Password: "));
		add(password);
		add(login);
		add(register);
		setVisible(true);
	}

	/**
     * /** Method handles actions
     * @param e action
     * @return nothing
     */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			String u = username.getText();
			String p = new String(password.getPassword());

            if (!inVal.isValidUN(u)) {
                System.out.println("nope");
            } else if (!inVal.isValidPW(p)) {
                System.out.println("Error");
            } else {
				Map<String, String> rawUser = services.Authenticate(u, p);
				UserData user = new UserData(rawUser);

				if (user.getHash().isEmpty()) {
					System.out.println("No user info");
				} else {
					this.dispose();
					new HomeFrame(user);
				}
			}
		} else if (e.getSource() == register) {
			this.dispose();
			new RegisterFrame();
		}
		
	}
}



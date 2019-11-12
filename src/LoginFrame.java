import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	private	Auth services = new Auth();
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private JButton login, register;
	private JLabel label1;
	private JLabel label2;

	public static void main(String[] args) {
		new LoginFrame();
	}

	LoginFrame() {
		label1 = new JLabel("Username: ");
		label2 = new JLabel("Password: ");
		
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

		add(label1);
		add(username);
		add(label2);
		add(password);
		add(login);
		add(register);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			String u = username.getText();
			String p = new String(password.getPassword());

            if (!Pattern.matches("[a-zA-Z]{2,20}", u)) {
                System.out.println("nope");
            } else if (!Pattern.matches("[a-zA-Z]{2,20}", p)) {
                System.out.println("Error");
            }		

			Map<String, String> user = services.Authenticate(u, p);
			for (Entry<String, String> entry : user.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());	
			}
			new HomeFrame(user);
		} else if (e.getSource() == register) {
			this.dispose();
			new RegisterFrame();
		}
	}
}



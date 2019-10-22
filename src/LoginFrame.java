import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField username, password;
	private JButton login;
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
		login.addActionListener(this);
		username.addActionListener(this);
		password.addActionListener(this);

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
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			String u = username.getText();
			String p = username.getText();

			Auth services = new Auth();
			Map<String, String> user = services.Authenticate(u, p);
			for (Entry<String, String> entry : user.entrySet()) {
				System.out.println(entry);
			}
		
			this.dispose();
			new MainFrame();

			System.out.println(); 
		}
	}
}



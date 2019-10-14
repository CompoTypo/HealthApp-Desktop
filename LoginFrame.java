import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.security.*;
import java.nio.charset.StandardCharsets;

public class LoginFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField username, password;
	private JButton login;
	private JLabel label1;
	private JLabel label2;

	private static String hashPassWord(String w) throws NoSuchAlgorithmException {
		final MessageDigest digest = MessageDigest.getInstance("SHA-256");
		final byte[] hashbytes = digest.digest(w.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hashbytes);
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
		}
		return hexString.toString();
	}

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
			String p = password.getText();
/* ***for testing purposes***
			if (u.equals("a") && p.equals("b")) {
				System.out.println("You logged in");
				this.dispose();
				new MainFrame();
			} else {
				System.out.println("Incorrect");
			}
*/
			
			String res;
			try { 
				res = hashPassWord(p); 
				for(int i = 0; i < res.length(); i++) {
					System.out.print(res.charAt(i)); 
				} 
				System.out.println("You logged in");
				this.dispose();
				new MainFrame();
			} 
			catch (Exception he) { 
				// reset login attempt
				System.out.println(he); 
			} 


			System.out.println(); 
		}
	}
}



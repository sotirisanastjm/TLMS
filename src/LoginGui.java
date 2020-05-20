import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginGui extends JFrame{
	
	
	private JFrame f;
	private ImageIcon titleicon;
	private ImageIcon logo;
	private JPanel panel;
	private JPanel btnarea;
	private JPanel infopanel;
	private JLabel userlabel;
	private JLabel pswrdlabel;
	private JLabel logolabel;
	private JButton btn1;// Login Button
	private JButton btn2;// Sign up Button
	private JButton btn3;// Login as a Customer
	private JTextField username;
	private JPasswordField password;
	
	
	public LoginGui() {
		
		f= new JFrame();
		titleicon = new ImageIcon("C:\\Users\\Sotiris\\Documents\\Eclipse_Java\\TLMS\\TLMS2.png");
		logo = new ImageIcon("C:\\Users\\Sotiris\\Documents\\Eclipse_Java\\TLMS\\TLMS1.png");
		panel=new JPanel();
		logolabel = new JLabel(logo);
		logolabel.setOpaque(true);
		btnarea=new JPanel();
		btn1= new JButton("Login");
		btn2= new JButton("Sign up");
		btn3 = new JButton("Connect as a Customer");
		infopanel=new JPanel();
		userlabel=new JLabel();
		pswrdlabel=new JLabel();
		username=new JTextField(15);
		password=new JPasswordField(15);
		
		
		/*Login Screen consist of 3 parts 
		 * panel:contains the label(logo of the app)
		 * btnarea:contains the buttons
		 * infopanel:contains labels and textfields about username-password */
		
		
		panel.setLayout(new BorderLayout());
		panel.add(logolabel,BorderLayout.NORTH);
		
		
		btnarea.add(btn1);
		btnarea.add(btn2);
		btnarea.add(btn3);
		btnarea.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		userlabel.setText("Username:");
		pswrdlabel.setText("Password:");
		infopanel.add(userlabel);
		infopanel.add(username);
		infopanel.add(pswrdlabel);
		infopanel.add(password);
		panel.add(infopanel,BorderLayout.CENTER);
		
		
		
		panel.add(btnarea,BorderLayout.SOUTH);
		
		
		
		f.add(panel);
		f.setLocation(600,300);
		f.setIconImage(titleicon.getImage());
		f.setContentPane(panel);
		f.setVisible(true);
		f.setSize(800,550);
		f.setTitle("Traffic Light Managment System");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AdminRegistry admin = new AdminRegistry();
				admin.isAdmin(username.getText(),String.valueOf(password.getPassword()));
				if(admin.getAdminFlag()) {
					f.dispose();
					new StartMenuGUI();
				}else JOptionPane.showMessageDialog(f,"There is a problem with your username/password \n"
						+ "Please try again");
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.dispose();
				new SignupGui();
				
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.dispose();
				new StartMenuGUI();
			}
		});
		
		
	
	}
	
}

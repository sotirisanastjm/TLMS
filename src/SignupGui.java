import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
@SuppressWarnings("serial")

public class SignupGui extends JFrame {
	
	private JFrame f;
	private ImageIcon titleicon;
	private ImageIcon logo;
	private JPanel panel;
	private JLabel logolabel;
	private JPanel infopanel;
	private JLabel userlabel;
	private JLabel fullnamelabel;
	private JLabel pswrdlabel1;
	private JLabel pswrdlabel2;
	private JLabel key;
	private JButton createacc;
	private JPasswordField pswrd1;
	private JPasswordField pswrd2;
	private JTextField fllname;
	private JTextField usrname;
	private JTextField keyfield;
	private JPanel btnpanel;

	
	public SignupGui() {
		
		f = new JFrame();
		titleicon = new ImageIcon("C:\\Users\\Sotiris\\Documents\\Eclipse_Java\\TLMS\\TLMS2.png");
		logo = new ImageIcon("C:\\Users\\Sotiris\\Documents\\Eclipse_Java\\TLMS\\TLMS1.png");
		panel=new JPanel();
		logolabel = new JLabel(logo);
		logolabel.setOpaque(true);
		infopanel= new JPanel();
		userlabel= new JLabel();
		fullnamelabel= new JLabel();
		pswrdlabel1=new JLabel();
		pswrdlabel2=new JLabel();
		key = new JLabel();
		createacc=new JButton("Create an Administrator Account");
		pswrd1= new JPasswordField(15);
		pswrd2= new JPasswordField(15);
		fllname=new JTextField(25);
		usrname=new JTextField(15);
		keyfield=new JTextField(5);
		btnpanel= new JPanel();
		
		
		
		panel.setLayout(new BorderLayout());
		panel.add(logolabel,BorderLayout.NORTH);
		
		
		fullnamelabel.setText("Full Name:");
		userlabel.setText("Username:");
		pswrdlabel1.setText("Password:");
		pswrdlabel2.setText("Confirmation Password:");
		key.setText("Administrator Key:");
		infopanel.add(fullnamelabel);
		infopanel.add(fllname);
		infopanel.add(userlabel);
		infopanel.add(usrname);
		infopanel.add(key);
		infopanel.add(keyfield);
		infopanel.add(pswrdlabel1);
		infopanel.add(pswrd1);
		infopanel.add(pswrdlabel2);
		infopanel.add(pswrd2);
		
		btnpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnpanel.add(createacc);
		panel.add(btnpanel,BorderLayout.SOUTH);
		panel.add(infopanel,BorderLayout.CENTER);
		
		f.add(panel);
		f.setLocation(600,300);
		f.setIconImage(titleicon.getImage());
		f.setContentPane(panel);
		f.setVisible(true);
		f.setSize(800,550);
		f.setTitle("Traffic Light Managment System");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		
		
		createacc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fullname=fllname.getText();
				String username=usrname.getText();
				String keystrng=keyfield.getText();
				String password1=String.valueOf(pswrd1.getPassword());
				String password2=String.valueOf(pswrd2.getPassword());
				AdminRegistry admin = new AdminRegistry();
				if(password1.equals(password2)&&!(password1.equals(""))&&keystrng.equals("admin")){
					admin.isAdmin(username, password1);
					if(!admin.getAdminFlag()) {
						try {
							BufferedWriter out = new BufferedWriter(new FileWriter("AdminList.dat",true)); 
							out.write("\nFull Name: "+fullname);
							out.write("\nUsername: "+username);
							out.write("\nPassword: "+password1);
							out.close();
							f.dispose();
							new StartMenuGUI();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.print("ERROR SIGNUP FILE NOT OPENING");
						}
					}else JOptionPane.showMessageDialog(f,"This username exists");
				}else {
					if((keystrng.equals("admin"))) {
						JOptionPane.showMessageDialog(f,"Wrong Password");
					}else JOptionPane.showMessageDialog(f,"Wrong Key");
				}
			}
			
		});
	}
	
}

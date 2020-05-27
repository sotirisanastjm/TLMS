
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class StartMenuGUI extends JFrame{
	
	
	private JFrame f;
	private ImageIcon titleicon;
	private JButton btn1;//Find btn
	private JButton btn2;//Tab btn
	private JPanel panel1;
	private JPanel panel;
	private JLabel label1;//Label for Find btn
	private JLabel label2;//Label for Tab btn
	private ImageIcon logo;
	private JLabel logolabel;
	
	public StartMenuGUI() {
		
		label1= new JLabel();
		label2= new JLabel();
		panel1=new JPanel();
		panel=new JPanel();
		f = new JFrame();
		logo = new ImageIcon("TLMS1.png");
		logolabel = new JLabel(logo);
		logolabel.setOpaque(true);
		titleicon=new ImageIcon("TLMS2.png");
		btn1=new JButton("Find Light");
		btn2=new JButton("Traffic Light Tab");
		
		label1.setText("Would you like to search for a Traffic Light?");
		label2.setText("Would you like to open the Traffic LIght Tab?");
		
		panel.setLayout(new BorderLayout());
		
		panel1.add(label1);
		panel1.add(btn1);
		panel1.add(label2);
		panel1.add(btn2);
		
		panel.add(logolabel,BorderLayout.NORTH);
		panel.add(panel1,BorderLayout.CENTER);
		
		
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
				new FindLightGUI();
				f.dispose();
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TrafficLightTabGUI();
				f.dispose();
			}
			
		});
	}

}

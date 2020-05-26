import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")

public class FindLightGUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnShow, btnShowDetails, btnCreate, btnBack;
	private JTextField textId;
	private ImageIcon titleicon;
	
	public FindLightGUI() {
		
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnShow = new JButton("Show Traffic Light");
		btnShowDetails = new JButton("Show Details");
		btnCreate = new JButton("Create");
		btnBack = new JButton("Back to Start Menu");
		textId = new JTextField("insert Id");
		
		panel.add(textId);
		panel.add(btnShow);
		panel.add(btnShowDetails);
		if(Main.AdminList.getAdminFlag() == true) {
			panel.add(btnCreate);
		}
		panel.add(btnBack);
		
		frame.setResizable(false);
		frame.setLocation(600,300);
		frame.setIconImage(titleicon.getImage());
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Find Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StartMenuGUI();
				frame.dispose();
			}
			
		});
	}

}

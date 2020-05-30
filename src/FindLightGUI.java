import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		textId = new JTextField("insert Id",10);
		
		panel.add(textId);
		panel.add(btnShow);
		panel.add(btnShowDetails);
		panel.add(btnCreate);
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
				
				String stringId = textId.getText();
				if(stringId != null && !stringId.equals("insert Id")) {
					int id = Integer.parseInt(stringId);
					if(Main.TrafficLightList.getTrafficLight(id) != null) {
						new ShowTrafficLightGUI(Main.TrafficLightList.getTrafficLight(id));
						frame.dispose();
					}else {
					JOptionPane.showMessageDialog(null, "The traffic light you are looking for does not exist.");
					}					
				}else {
					JOptionPane.showMessageDialog(null, "Please type a valid ID");
				}
			}
		});
		
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String stringId = textId.getText();
				if(stringId != null && !stringId.equals("insert Id")) {
					int id = Integer.parseInt(stringId);
					if(Main.TrafficLightList.getTrafficLight(id) != null) {
						new ShowTrafficLightDetailsGUI(Main.TrafficLightList.getTrafficLight(id));
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "The traffic light you are looking for does not exist.");
					}
				
				}else {
					JOptionPane.showMessageDialog(null, "Please type a valid ID");
				}
			}
			
		});
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				
				
				if(Main.AdminList.getAdminFlag() == true) {
					
					String stringId = textId.getText();
					int id = Integer.parseInt(stringId);
					
					if(Main.TrafficLightList.getTrafficLight(id) == null) {
						new CreateGUI(id);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "The traffic light you are trying to create already exists.");
					}	
				}else {
					JOptionPane.showMessageDialog(null, "You must sign in as an Administrator to use this button.");
				}
				
			}
			
		});
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new StartMenuGUI();
				frame.dispose();
			}
			
		});
	}

}

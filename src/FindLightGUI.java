import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class FindLightGUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnShow, btnShowDetails, btnCreate, btnBack;
	private JTextField textId;
	private ImageIcon titleicon;
	private JPanel btnarea;
	private ImageIcon image;
	private JLabel imagelabel;
	public FindLightGUI() {
		
		image=new ImageIcon("wonderclipart.png");
		imagelabel=new JLabel(image);
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnarea=new JPanel();
		btnShow = new JButton("Show Traffic Light");
		btnShowDetails = new JButton("Show Details");
		btnCreate = new JButton("Create");
		btnBack = new JButton("Back to Start Menu");
		textId = new JTextField("insert Id",10);
		

		panel.add(imagelabel);
		btnarea.add(textId);
		btnarea.add(btnShow);
		btnarea.add(btnShowDetails);
		btnarea.add(btnCreate);
		btnarea.add(btnBack);
		panel.add(btnarea);
		
		frame.setResizable(false);
		frame.setLocation(500,200);
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
				if(stringId.matches("[0-9]+")) {
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
				}else JOptionPane.showMessageDialog(null,"You must put only numbers\n"
						+ "Please try again");
				
			}
		});
		
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String stringId = textId.getText();
				if(stringId.matches("[0-9]+")) {
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
				}else JOptionPane.showMessageDialog(null,"You must put only numbers\n"
						+ "Please try again");
				
			}
			
		});
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				String stringId = textId.getText();
				if(stringId.matches("[0-9]+")) {
					if(Main.AdminList.getAdminFlag() == true) {
						
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
				}else if(stringId.equals("") || stringId.equals("insert Id") ) {
					JOptionPane.showMessageDialog(null,"You must put an Id to create a Traffic Light\n"
							+ "Please try again");
				}else JOptionPane.showMessageDialog(null,"You must put only numbers\n"
						+ "Please try again");
				
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

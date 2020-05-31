import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ShowTrafficLightDetailsGUI {
	
	private final static String newline = "\n";
	private TrafficLight currentTrafficLight;
	
	public ShowTrafficLightDetailsGUI(TrafficLight aTrafficLight) {
		
		int currentId = aTrafficLight.getId();
		currentTrafficLight = Main.TrafficLightList.getTrafficLight(currentId);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JButton btnBack = new JButton("Back to Info");
		JButton btnEdit = new JButton("Edit Details");
		JButton btnChangeType_Delete = new JButton("Change Type or Delete");
		JLabel label = new JLabel("Details");
		JLabel idLabel = new JLabel("ID:");
		JTextField id = new JTextField(String.valueOf(currentTrafficLight.getId()));
		
		JTextArea detailsArea = new JTextArea(7, 40);
		detailsArea.setEditable(false);
		id.setEditable(false);
		String text1="";
		String text4="It does not have a Sign";
		String text5="It does not have a Crosswalk";
		String text="This is a ";
		String text2="It is located at ";
		String text3="The Traffic Light has the color ";
		if(currentTrafficLight.getType()==0) {
			text1="Pedestrian Traffic Light";
		}else if(currentTrafficLight.getType()==1) {
			text1="Three Color Traffic Light";
		}else if(currentTrafficLight.getType()==2) {
			text1="Single Color Traffic Light";
		}else if(currentTrafficLight.getType()==3) {
			text1="Bicycle Traffic Light";
		}
		if(currentTrafficLight.isSign())
			text4 = "It has a Sign";
		if(currentTrafficLight.isCrosswalk())
			text5="It has a Crosswalk";
		detailsArea.append(text + text1 + newline);
		detailsArea.append(text2 + currentTrafficLight.getStreet() + " " + String.valueOf(currentTrafficLight.getStreetNumber()) + newline);
		detailsArea.append(text3 + currentTrafficLight.getColor() + newline);
		detailsArea.append(text4 + newline);
		detailsArea.append(text5 + newline);
		
		panel.add(idLabel);
		panel.add(id);
		panel.add(label);
		panel.add(detailsArea);
		
		buttonsPanel.add(btnBack);
		buttonsPanel.add(btnEdit);
		buttonsPanel.add(btnChangeType_Delete);
		
		frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
		
		frame.setVisible(true);
		frame.setSize(500,350);
		frame.setTitle("Traffic Light Managment System - Traffic Light Details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ShowTrafficLightGUI(currentTrafficLight);
				frame.dispose();
			}});
		
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditDetailsGUI(currentTrafficLight);
				frame.dispose();		
			}});
		
		btnChangeType_Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(Main.AdminList.getAdminFlag() == true) {
					new ChangeType_DeleteGUI(currentTrafficLight);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "You must sign in as an Administrator to use this button.");
				}
						
			}});
			
	}

}

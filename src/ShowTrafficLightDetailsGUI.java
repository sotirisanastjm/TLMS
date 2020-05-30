import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ShowTrafficLightDetailsGUI {
	
	private final static String newline = "\n";
	
	public ShowTrafficLightDetailsGUI(TrafficLight aTrafficLight) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JButton btnBack = new JButton("Back to Info");
		JButton btnEdit = new JButton("Edit Details");
		JLabel label = new JLabel("Details");
		JLabel idLabel = new JLabel("ID:");
		JTextField id = new JTextField(String.valueOf(aTrafficLight.getId()));
		
		JTextArea detailsArea = new JTextArea(7, 40);
		detailsArea.setEditable(false);
		id.setEditable(false);
		String text1="";
		String text4="It does not have a Sign";
		String text5="It does not have a Crosswalk";
		String text="This is a ";
		String text2="It is located at ";
		String text3="The Traffic Light has the color ";
		if(aTrafficLight.getType()==0) {
			text1="Pedestrian Traffic Light";
		}else if(aTrafficLight.getType()==1) {
			text1="Three Color Traffic Light";
		}else if(aTrafficLight.getType()==2) {
			text1="Single Color Traffic Light";
		}else if(aTrafficLight.getType()==3) {
			text1="Bicycle Traffic Light";
		}
		if(aTrafficLight.isSign())
			text4 = "It has a Sign";
		if(aTrafficLight.isCrosswalk())
			text5="It has a Crosswalk";
		detailsArea.append(text + text1 + newline);
		detailsArea.append(text2 + aTrafficLight.getStreet() + " " + String.valueOf(aTrafficLight.getStreetNumber()) + newline);
		detailsArea.append(text3 + aTrafficLight.getColor() + newline);
		detailsArea.append(text4 + newline);
		detailsArea.append(text5 + newline);
		
		panel.add(idLabel);
		panel.add(id);
		panel.add(label);
		panel.add(detailsArea);
		
		buttonsPanel.add(btnBack);
		buttonsPanel.add(btnEdit);
		
		frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
		
		frame.setVisible(true);
		frame.setSize(500,350);
		frame.setTitle("Traffic Light Managment System - Traffic Light Details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ShowTrafficLightGUI(aTrafficLight);
				frame.dispose();
			}});
		
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditDetailsGUI(aTrafficLight);
				frame.dispose();		
			}});
			
	}

}

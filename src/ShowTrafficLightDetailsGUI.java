import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ShowTrafficLightDetailsGUI {
	
	
	
	public ShowTrafficLightDetailsGUI(TrafficLight aTrafficLight) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JButton btnBack = new JButton("Back to Info");
		JLabel label = new JLabel("Mao");
		JTextField text1 = new JTextField(10);
		
		panel.add(label);
		panel.add(text1);
		
		buttonsPanel.add(btnBack);
		
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
			
	}

}

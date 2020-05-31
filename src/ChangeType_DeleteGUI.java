import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeType_DeleteGUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnDelete, btnChangeType, btnBack;
	private JTextField textNewType;
	private ImageIcon titleicon;
	private TrafficLight currentTrafficLight;
	private JLabel labelType0, labelType1, labelType2, labelType3;
	private boolean isTrafficLightDeleted;
	
	public ChangeType_DeleteGUI(TrafficLight aTrafficLight) {
		
		isTrafficLightDeleted = false;
		
		currentTrafficLight = aTrafficLight;
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnDelete = new JButton("Delete Traffic Light");
		btnChangeType = new JButton("Change Traffic Light Type");
		btnBack = new JButton("Back to Show Details");
		textNewType = new JTextField("insert new Type", 10);
		labelType0 = new JLabel("0: Pedestrian Traffic Light.");
		labelType1 = new JLabel("1: Threecolor Traffic Light.");
		labelType2 = new JLabel("2: Singlecolor Traffic Light.");
		labelType3 = new JLabel("3: Bicycle Traffic Light.");
		
		panel.add(textNewType);
		panel.add(btnChangeType);
		panel.add(btnDelete);
		panel.add(btnBack);
		panel.add(labelType0);
		panel.add(labelType1);
		panel.add(labelType2);
		panel.add(labelType3);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Change Type/Delete Traffic Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!isTrafficLightDeleted) {
					new ShowTrafficLightDetailsGUI(currentTrafficLight);
					frame.dispose();
				}else {
					new FindLightGUI();
					frame.dispose();
					JOptionPane.showMessageDialog(null, "You were redirected to Find Light screen since you deleted the current Traffic Light.");	
				}
				
			}
		});
		
		btnChangeType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int currentId = currentTrafficLight.getId();
				
				if(Main.TrafficLightList.getTrafficLight(currentId) != null) {
					
					String stringNewType = textNewType.getText();
					int newType = Integer.parseInt(stringNewType);
					
					if(newType == 0 || newType == 1 || newType == 2 || newType == 3) {
						Main.TrafficLightList.changeType(currentTrafficLight.getId(), newType);
						JOptionPane.showMessageDialog(null, "You succesfully changed the type of the Traffic Light");
					}else {
						JOptionPane.showMessageDialog(null, "The new type parameter must be 0, 1, 2, or 3.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "You have deleted this Traffic Light.");
				}
				
					
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int currentId = currentTrafficLight.getId();
				
				if(Main.TrafficLightList.getTrafficLight(currentId) != null) {
					isTrafficLightDeleted = true;
					Main.TrafficLightList.delete(currentId);
					JOptionPane.showMessageDialog(null, "You succesfully deleted the Traffic Light.");
				}else {
					JOptionPane.showMessageDialog(null, "You have already deleted this Traffic Light.");
				}
		
			}
		});
		
	}
}

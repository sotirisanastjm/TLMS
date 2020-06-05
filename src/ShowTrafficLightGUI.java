import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShowTrafficLightGUI {
	
	public ShowTrafficLightGUI(TrafficLight aTrafficLight) {
		
		//image
		ImageIcon titleicon=new ImageIcon("TLMS2.png");
		
		//frame
		JFrame frame = new JFrame();		
		
		//panels
		JPanel panel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//buttons
		
		JButton btnShowDetails = new JButton("Show Traffic Light Details");
		JButton btnBack = new JButton("Back to Search for a Traffic Light");
		JButton btnEditInfo = new JButton("Edit Info");
		JButton btnSave = new JButton("Save Changes");
		
		//TextFields
		JTextField idTxt = new JTextField(String.valueOf(aTrafficLight.getId()));
		idTxt.setEditable(false);
		JTextField typeTxt = new JTextField(String.valueOf(aTrafficLight.getType()));
		typeTxt.setEditable(false);
		JTextField streetTxt = new JTextField(aTrafficLight.getStreet());
		streetTxt.setEditable(false);
		JTextField colorTxt  = new JTextField(aTrafficLight.getColor());
		colorTxt.setEditable(false);
				
		//Labels
		JLabel idLab = new JLabel("ID:");
		idLab.setLabelFor(idTxt);
		JLabel type = new JLabel("Type:");
		type.setLabelFor(typeTxt);
		JLabel street = new JLabel("Street:");
		street.setLabelFor(streetTxt);
		JLabel color = new JLabel("Color:");
		color.setLabelFor(colorTxt);
		
		
		GridBagLayout gridbag = new GridBagLayout();
	    GridBagConstraints c = new GridBagConstraints();
	 
	    panel.setLayout(gridbag);
	 
	    JLabel[] labels = {idLab,type,street,color};
	    JTextField[] textFields = {idTxt,typeTxt,streetTxt,colorTxt};
	    addLabelTextRows(labels, textFields, gridbag, panel);
	 
	    c.gridwidth = GridBagConstraints.REMAINDER; //last
	    c.anchor = GridBagConstraints.WEST;
	    c.weightx = 1.0;
	    panel.add(btnBack,c);
	    panel.setBorder(
	               BorderFactory.createCompoundBorder(
	               BorderFactory.createTitledBorder("Traffic Light Info"),
	               BorderFactory.createEmptyBorder(5,5,5,5)));

		buttonPanel.add(btnShowDetails);
		if (Main.AdminList.getAdminFlag()) {
			buttonPanel.add(btnEditInfo);
			buttonPanel.add(btnSave);
		}
		
			
		
		//soyma
		frame.setIconImage(titleicon.getImage());
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);      
        frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Show Traffic Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnEditInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//if the user is admin, he can edit textfields
					idTxt.setEditable(true);
					typeTxt.setEditable(true);
					streetTxt.setEditable(true);
					colorTxt.setEditable(true);			
			}});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String stringId = idTxt.getText();
				int id = Integer.parseInt(stringId);
				String stringType = typeTxt.getText();
				int type = Integer.parseInt(stringType);
				String street = streetTxt.getText();
				String color = colorTxt.getText();
				//cases when id and type stay the same
				if(id == aTrafficLight.getId() && type == aTrafficLight.getType()) {
					if(street != aTrafficLight.getStreet() && color == aTrafficLight.getColor() && street != "") {
						aTrafficLight.setStreet(street);
						JOptionPane.showMessageDialog(null, "You successfully edited the Traffic Light's street.");		
					}
					if(street != aTrafficLight.getStreet() && color == aTrafficLight.getColor() && street == "") {
						JOptionPane.showMessageDialog(null, "Street field cannot be empty");
					}
					if(color != aTrafficLight.getColor() && street == aTrafficLight.getStreet() && color != "") {
						aTrafficLight.setColor(color);
						JOptionPane.showMessageDialog(null, "You successfully edited the Traffic Light's color.");	
					}
					if(color != aTrafficLight.getColor() && street == aTrafficLight.getStreet() && color == "")
						JOptionPane.showMessageDialog(null, "Color field cannot be empty");
				}
				if(stringId == null){
					JOptionPane.showMessageDialog(null, "ID field cannot be empty");
				}
				if(stringType == null) {
					JOptionPane.showMessageDialog(null, "Type field cannot be empty");
				}
				if(Main.TrafficLightList.getTrafficLight(id) == null) {
					
					if(JOptionPane.showConfirmDialog(null,"Traffic Light does not exist, do you want to create a new one?", "NO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						new CreateGUI(id);
						frame.dispose();
					}
				}
				
					
			}});
		
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					new ShowTrafficLightDetailsGUI(aTrafficLight);
					frame.dispose();
				}
			
			
		});
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					new FindLightGUI();
					frame.dispose();
				}
			
			
		});
		
	}
	
    private void addLabelTextRows(JLabel[] labels,JTextField[] textFields,GridBagLayout gridbag,Container container) {
    	GridBagConstraints c = new GridBagConstraints();
    	c.anchor = GridBagConstraints.EAST;
    	int numLabels = labels.length;

    	for (int i = 0; i < numLabels; i++) {
    		c.gridwidth = GridBagConstraints.RELATIVE; 
    		c.fill = GridBagConstraints.NONE;      
    		c.weightx = 0.0;                       
    		container.add(labels[i], c);

    		c.gridwidth = GridBagConstraints.REMAINDER;    
    		c.fill = GridBagConstraints.HORIZONTAL;
    		c.weightx = 1.0;
    		container.add(textFields[i], c);
    	}
    }

}

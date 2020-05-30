import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class CreateGUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnCreate, btnBack;
	private JTextField textType, textStreet, textNumber;
	private ImageIcon titleicon;
	private JCheckBox sign, crosswalk;
	private boolean signChecked,crosswalkChecked;
	public CreateGUI(int id) {
		String signString, crosswalkString;
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnCreate = new JButton("Create Traffic Light");
		btnBack = new JButton("Back to Find Light");
		textType = new JTextField("insert type");
		textStreet = new JTextField("insert street");
		textNumber = new JTextField("insert street number");
		signString = "Sign";
		crosswalkString = "Crosswalk";
		Choice ColorChooser = new Choice();
		ColorChooser.add("Green");
		ColorChooser.add("Red");
		ColorChooser.add("Yellow");
		
		sign = new JCheckBox(signString, false);
		crosswalk = new JCheckBox(crosswalkString, false);
		
		panel.add(textType);
		panel.add(textStreet);
		panel.add(textNumber);
		panel.add(ColorChooser);
		panel.add(sign);
		panel.add(crosswalk);
		panel.add(btnCreate);
		panel.add(btnBack);
		
		frame.setResizable(false);
		frame.setLocation(600,300);
		frame.setIconImage(titleicon.getImage());
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Create Traffic Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new FindLightGUI();
				frame.dispose();
			}
			
		});
		
		sign.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
                signChecked = true;    
                   
             }    
          }); 
		
		crosswalk.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
            	crosswalkChecked = true;    
                  
            }    
         }); 
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String stringType = textType.getText();
				int type = Integer.parseInt(stringType);
				
				String street = textStreet.getText();
				String color = ColorChooser.getSelectedItem();
				String stringStreetNumber = textNumber.getText();
				int streetNumber = Integer.parseInt(stringStreetNumber);
				
				if(stringType != "" && street != "" && stringStreetNumber != "") {
					if(type == 0 || type == 1 || type == 2 || type == 3) {
						if(Main.TrafficLightList.getTrafficLight(id) == null) {
							Main.TrafficLightList.create(id, type, street, streetNumber, color, signChecked, crosswalkChecked);
							JOptionPane.showMessageDialog(null, "You successfully created the Traffic Light.");
						}else {
							JOptionPane.showMessageDialog(null, "You have already created a Traffic Light with this id.");
						}
					}else {
						JOptionPane.showMessageDialog(null,"The type parameter must be 0, 1, 2, or 3.");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "You must fill all the blanck boxes.");
				}
				
			}
			
		});
		
	}

}

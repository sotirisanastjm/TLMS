import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShowTrafficLightGUI {
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnFindLight, btnShowDetails, btnBack;
	private JTextField textAttributes;
	
	public ShowTrafficLightGUI() {
		
		frame = new JFrame();
		panel = new JPanel();
		btnFindLight = new JButton("Find Traffic Light");
		btnShowDetails = new JButton("Show Traffic Light Details");
		btnBack = new JButton("Back to Traffic Light Tab");
		textAttributes = new JTextField(10);
		
		panel.add(textAttributes);
		panel.add(btnFindLight);
		panel.add(btnShowDetails);
		panel.add(btnBack);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Show Traffic Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

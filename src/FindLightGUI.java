import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindLightGUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JButton btnShow, btnShowDetails, btnCreate, btnBack;
	private JTextField textId;
	
	public FindLightGUI() {
		
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
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Find Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

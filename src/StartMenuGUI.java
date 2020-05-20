import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartMenuGUI extends JFrame{
	
	
	private JFrame f;
	private ImageIcon titleicon;
	private JButton btn1;//Find btn
	private JButton btn2;//Tab btn
	
	public StartMenuGUI() {
		
		
		f = new JFrame();
		titleicon=new ImageIcon("C:\\Users\\Sotiris\\Documents\\Eclipse_Java\\TLMS\\TLMS2.png");
		btn1=new JButton("Find Light");
		btn2=new JButton("Traffic Light Tab");
		
		//f.add(panel);
		f.setLocation(600,300);
		f.setIconImage(titleicon.getImage());
		//f.setContentPane(panel);
		f.setVisible(true);
		f.setSize(800,550);
		f.setTitle("Traffic Light Managment System");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}

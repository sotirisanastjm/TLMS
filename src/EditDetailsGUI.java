import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//this class finds the next and the previous Traffic Lights

@SuppressWarnings("serial")
public class EditDetailsGUI extends JFrame{
	
	private JFrame f;
	private JPanel panel;
	private ImageIcon titleicon;
	private JButton btnprev;
	private JButton btnnext;
	private JButton btncurr;
	private JButton btnback;
	private JButton btnstartmenu;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JScrollPane scrollpane;
	private JLabel label;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditDetailsGUI(TrafficLight light){
		
		int id=0;
		id=light.getId();
		ArrayList<TrafficLight> TrafficLightNext = new ArrayList<>(Main.TrafficLightList.findNext(id));
		ArrayList<TrafficLight> TrafficLightPrev = new ArrayList<>(Main.TrafficLightList.findPrev(id));
		
		DefaultListModel list1= new DefaultListModel();
		list1.addElement(light);
		
		label=new JLabel("Current Traffic Light");
		f = new JFrame();
		panel= new JPanel();
		btnprev= new JButton("Previous Traffic Lights");
		btnnext= new JButton("Next Traffic Lights");
		btncurr= new JButton("Current Traffic Light");
		btnback= new JButton("Back to Show Details");
		btnstartmenu= new JButton("Back to Start Menu");
		titleicon=new ImageIcon("TLMS2.png");
		list = new JList(list1);
		list.setPreferredSize(new Dimension(400,200));
		list.setCellRenderer(new TrafficRenderer());
		scrollpane = new JScrollPane(list);
		
		
		
		
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(label);
		panel.add(scrollpane);
		panel.add(btnprev);
		panel.add(btncurr);
		panel.add(btnnext);
		panel.add(btnback);
		panel.add(btnstartmenu);	
		
		
		
		
		
		f.setResizable(false);
		f.setLocation(600,300);
		f.setSize(500,350);
		f.setIconImage(titleicon.getImage());
		f.setContentPane(panel);
		f.setVisible(true);
		f.setTitle("Traffic Light Managment System - Edit Details");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		btncurr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				list1.removeAllElements();
				label.setText("Current Traffic Light");
				list1.addElement(light);
				list.setModel(list1);
			}
			
		});
		btnprev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(TrafficLightPrev.size()!=0) {
					list1.removeAllElements();
					for(int i=0;i<TrafficLightPrev.size();i++) {
						list1.addElement(TrafficLightPrev.get(i));
					}
					label.setText("The Previous Traffic Lights");
					list.setModel(list1);
				}else JOptionPane.showMessageDialog(f,"There are no Previous Traffic Lights");
			}
			
		});
		btnnext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(TrafficLightNext.size()!=0) {
					list1.removeAllElements();
					for(int i=0;i<TrafficLightNext.size();i++) {
						list1.addElement(TrafficLightNext.get(i));
					}
					label.setText("The Next Traffic Lights");
					list.setModel(list1);
				}else JOptionPane.showMessageDialog(f,"There are no Next Traffic Lights");
			}
			
		});
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ShowTrafficLightDetailsGUI(light);
				f.dispose();
			}
			
		});
		btnstartmenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StartMenuGUI();
				f.dispose();
			}
			
		});
	}
}

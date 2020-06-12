//this GUI displays the traffic lists in a list
//the user can select to sort them
//or he can select a traffic light and then proceed with further actions
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("rawtypes")

public class TrafficLightTabGUI {
	
	private ImageIcon titleicon;
	private JFrame frame;
	private JPanel panel;
	private JButton btnSortType, btnSortId, btnShowDetails, btnShowTrafficLight, btnBack;
	
	private JList trafficLightList; 
	private JScrollPane scrollPane;
	

	
	
	@SuppressWarnings("unchecked")
	public TrafficLightTabGUI() {
		
		
		
		DefaultListModel list= new DefaultListModel();
		
		for (int i = 0; i < Main.TrafficLightList.getList().size(); i++)
		{
		    list.addElement(Main.TrafficLightList.getList().get(i));
		}
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnSortType = new JButton("Sort by Type");
		btnSortId = new JButton("Sort by Id");
		btnShowDetails = new JButton("Show Details"); 
		btnShowTrafficLight = new JButton("Show Traffic Light");
		btnBack = new JButton("Back to Start Menu");
		trafficLightList = new JList(list);
		trafficLightList.setCellRenderer(new TrafficRenderer());
		scrollPane = new JScrollPane(trafficLightList);
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		panel.add(btnSortType);
		panel.add(btnSortId);
		panel.add(btnShowDetails);
		panel.add(btnShowTrafficLight);
		panel.add(btnBack);
		
		
		frame.setResizable(false);
		frame.setLocation(600,300);
		frame.setIconImage(titleicon.getImage());
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(600,350);
		frame.setTitle("Traffic Light Managment System - Traffic Light Tab");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnSortType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.TrafficLightList.sortType();
				list.removeAllElements();
				for (int i = 0; i < Main.TrafficLightList.getList().size(); i++)
				{
				    list.addElement(Main.TrafficLightList.getList().get(i));
				}
				trafficLightList.setModel(list);
			}
			
		});
		btnSortId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.TrafficLightList.sortId();
				list.removeAllElements();
				for (int i = 0; i <Main.TrafficLightList.getList().size(); i++)
				{
				    list.addElement(Main.TrafficLightList.getList().get(i));
				}
				trafficLightList.setModel(list);
			}
			
		});
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trafficLightList.getSelectedValuesList().size()>1) {
					JOptionPane.showMessageDialog(frame,"You can only pick one Traffic Light");
				}else if(trafficLightList.getSelectedValuesList().size()<1){
					JOptionPane.showMessageDialog(frame,"You need to pick a Traffic Light");
				}else {
					new ShowTrafficLightDetailsGUI((TrafficLight)trafficLightList.getSelectedValue());
					frame.dispose();
				}
			}
			
		});
		btnShowTrafficLight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(trafficLightList.getSelectedValuesList().size()>1) {
					JOptionPane.showMessageDialog(frame,"You can only pick one Traffic Light");
				}else if(trafficLightList.getSelectedValuesList().size()<1){
					JOptionPane.showMessageDialog(frame,"You need to pick a Traffic Light");
				}else {
					new ShowTrafficLightGUI((TrafficLight)trafficLightList.getSelectedValue());
					frame.dispose();
				}
			}
			
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StartMenuGUI();
				frame.dispose();
			}
			
		});
		
	}
	

}


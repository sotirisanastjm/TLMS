

import java.awt.Dimension;
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
		//list.addElement(Main.TrafficLightList[0]);
		for (int i = 0; i < Main.TrafficLightList.getList().size(); i++)
		{
		    list.addElement(Main.TrafficLightList.getList().get(i));
		}
		titleicon=new ImageIcon("TLMS2.png");
		frame = new JFrame();
		panel = new JPanel();
		btnSortType = new JButton("Sort by Type");
		btnSortId = new JButton("Sort by Id");
		btnShowDetails = new JButton("Show Details"); /*Î�Î± Ï„Î¿ Î²Î±Î¶Î±Î¼Îµ Î¼Î¿Î½Î¿ ÏƒÏ„Î¿ ShowTrafficLightGUI; (Î³Î¹Î± Î½Î± Î¼Ï€Î¿Ï�ÎµÎ¹Ï‚ Î½Î± Ï€Î±Ï‚ ÏƒÏ„Î¿ ShowDetails Î¼Î¿Î½Î¿ ÎµÏ†Î¿ÏƒÎ¿Î½ ÎµÎ¹ÏƒÎ±Î¹ ÏƒÏ„Î¿ ShowTrafficLight*/
		btnShowTrafficLight = new JButton("Show Traffic Light");
		btnBack = new JButton("Back to Start Menu");
		trafficLightList = new JList(list);
		trafficLightList.setPreferredSize(new Dimension(700, 400));
		trafficLightList.setCellRenderer(new TrafficRenderer());/*ÎšÎ±Î½Î±Î¼Îµ Î»Î¹ÏƒÏ„Î± Î¼Îµ Ï„Î¿ ÏƒÎºÎµÏ€Ï„Î¹ÎºÎ¿ Î¿Ï„Î¹ Î¸Î± Î³ÎµÎ¼Î¹ÏƒÎ¿Ï…Î¼Îµ Î¼Îµ Î¿Î»ÎµÏ‚ Ï„Î¹Ï‚ ÎµÎ³Î³Ï�Î±Ï†ÎµÏ‚ Ï„Î¿Ï… Registry ÎºÎ±Î¹ Î¸Î± Ï†Î±Î¹Î½Î¿Î½Ï„Î±Î¹ 
Î¿Î»Î± Ï„Î± Ï†Î±Î½Î±Ï�Î¹Î± ÏƒÏ…Î½ÎµÏ‡Ï‰Ï‚, Î¿Î¼Ï‰Ï‚ Î´ÎµÎ½ Î¼Ï€Î¿Ï�Î¿Ï…Î¼Îµ Î½Î± Ï„Î± Î²Î±Î»Î¿Ï…Î¼Îµ ÏƒÎ±Î½ Î¿Î»Î¿ÎºÎ»Î·Ï�Î± Î±Î½Ï„Î¹ÎºÎµÎ¹Î¼ÎµÎ½Î±(??) Î³Î¹Î±Ï„Î¹ Î¸Î± Î·Ï„Î±Î½ ÎºÎ±Î»Ï…Ï„ÎµÏ�Î¿ Î½Î± Î²Î±Î¶Î±Î¼Îµ ÎºÎ±Ï€Î¿Î¹Î± Î²Î±ÏƒÎ¹ÎºÎ± attributes
Î½Î± ÎµÎ¼Ï†Î±Î½Î¹Î¶Î¿Î½Ï„Î±Î¹ Ï‰ÏƒÏ„Îµ Î½Î± ÎµÏ‡Î¿Ï…Î½ Î½Î¿Î·Î¼Î± ÎºÎ±Î¹ Ï„Î± Ï…Ï€Î¿Î»Î¿Î¹Ï€Î± gui*/
		scrollPane = new JScrollPane(trafficLightList);/*Ï„Î¿ Î²Î±Î»Î±Î¼Îµ Î³Î¹Î± Î½Î± ÎµÎ¼Ï†Î±Î½Î¹Î¶Î¿Î½Ï„Î±Î¹ ÏƒÎµ Ï€ÎµÏ�Î¹Î¿Ï�Î¹ÏƒÎ¼ÎµÎ½Î¿ Ï‡Ï‰Ï�Î¿ ÎºÎ±Î¹ Î½Î± ÎºÎ±Î½ÎµÎ¹ scroll (Î¿ Ï‡Ï�Î·ÏƒÏ„Î·Ï‚)
Î³Î¹Î± Î½Î± Î´ÎµÎ¹ Ï„Î± Ï†Î±Î½Î±Ï�Î¹Î±(Î±Î½ ÎµÎ¹Î½Î±Î¹ Î¿Î½Ï„Ï‰Ï‚ Ï€Î¿Î»Î»Î±)*/
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//ÎºÎ±Î½Î¿Î½Î±Ï‚ Î³Î¹Î± Î½Î± ÎµÎ¼Ï†Î±Î½Î¹Î¶ÎµÎ¹ Î¼Ï€Î±Ï�Î± 
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
		frame.setSize(800,550);
		frame.setTitle("Traffic Light Managment System - Traffic Light Tab");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnSortType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnSortId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnShowDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnShowTrafficLight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
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


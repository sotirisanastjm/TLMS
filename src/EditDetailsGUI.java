import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("serial")
public class EditDetailsGUI extends JFrame{
	
	private JFrame f;
	private JPanel panel;
	private ImageIcon titleicon;
	private JButton btnprev;
	private JButton btnnext;
	private JButton btnback;
	private JButton btnstartmenu;
	private JList list;
	private JScrollPane scrollpane;
	private JLabel label;

	
	public EditDetailsGUI(int id){
		int num=0;
		for(int i=0;i<Main.TrafficLightList.getList().size();i++) {
			if(id==Main.TrafficLightList.getList().get(i).getId()) {
				num=i;
			}
		}
		int prev=0;
		int next=0;
		int min=1000,max=-1;
		
		int streetnumb= Main.TrafficLightList.getList().get(num).getStreetNumber();
		String street = Main.TrafficLightList.getList().get(num).getStreet();
		
		for(int i=0;i<Main.TrafficLightList.getList().size();i++) {
			if(Main.TrafficLightList.getList().get(i).getStreet().equals(street)&&streetnumb<Main.TrafficLightList.getList().get(i).getStreetNumber()) {
				if(min>Main.TrafficLightList.getList().get(i).getStreetNumber()) {
					min=Main.TrafficLightList.getList().get(i).getStreetNumber();
					next=i;
				}
			}
			if(Main.TrafficLightList.getList().get(i).getStreet().equals(street)&&streetnumb>Main.TrafficLightList.getList().get(i).getStreetNumber()) {
				if(max<Main.TrafficLightList.getList().get(i).getStreetNumber()) {
					max=Main.TrafficLightList.getList().get(i).getStreetNumber();
					prev=i;
				}
			}
		}
		
		
		
		DefaultListModel list1= new DefaultListModel();
		list1.addElement(Main.TrafficLightList.getList().get(prev));
		DefaultListModel list2= new DefaultListModel();
		list2.addElement(Main.TrafficLightList.getList().get(next));
		DefaultListModel list3= new DefaultListModel();
		list3.addElement(Main.TrafficLightList.getList().get(num));
		
		label=new JLabel("Current Traffic Light");
		f = new JFrame();
		panel= new JPanel();
		btnprev= new JButton("Previous Traffic Light");
		btnnext= new JButton("Next Traffic Light");
		btnback= new JButton("Back to Show Details");
		btnstartmenu= new JButton("Back to Start Menu");
		titleicon=new ImageIcon("TLMS2.png");
		list = new JList(list3);
		list.setPreferredSize(new Dimension(700,400));
		list.setCellRenderer(new TrafficRenderer());
		scrollpane = new JScrollPane(list);
		
		
		
		
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(label);
		panel.add(scrollpane);
		panel.add(btnprev);
		panel.add(btnnext);
		panel.add(btnback);
		panel.add(btnstartmenu);	
		
		
		
		
		
		f.setResizable(false);
		f.setLocation(600,300);
		f.setSize(800, 550);
		f.setIconImage(titleicon.getImage());
		f.setContentPane(panel);
		f.setVisible(true);
		f.setTitle("Traffic Light Managment System - Edit Details");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		btnprev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("The Previous Traffic Light");
				list.setModel(list1);
				
			}
			
		});
		btnnext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("The Next Traffic Light");
				list.setModel(list2);
			}
			
		});
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ShowDetailsGUI();
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

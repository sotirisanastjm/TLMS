import java.awt.Component;

import javax.swing.*;

@SuppressWarnings("serial")
class TrafficRenderer extends DefaultListCellRenderer{
	 public Component getListCellRendererComponent(
		        @SuppressWarnings("rawtypes") JList list, Object value, int index,
		        boolean isSelected, boolean cellHasFocus)
		    {
		        super.getListCellRendererComponent(list, value,
		            index, isSelected, cellHasFocus);
		       ImageIcon icon=new ImageIcon("TLMS3.png");
		       TrafficLight light = (TrafficLight)value;
		       if(light.getColor().equals("green")) {
		    	   icon = new ImageIcon("TLMS4.png");
		       }else if(light.getColor().equals("yellow")) {
		    	   icon = new ImageIcon("TLMS5.png");
		       }
		       
		       	setIcon(icon);
		       	setText(light.getId()+" "+light.getType()+" "+light.getStreet()+" "+light.getStreetNumber()+" "+light.getColor());
		       	return this;
		    }
}

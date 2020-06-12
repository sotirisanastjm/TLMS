//this is a renderer for the Traffic light list
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
		       String lightType ="";
		       if( light.getType()==0) {
		    	   lightType="Pedestrian Traffic Light";
		       }else if( light.getType()==1) {
		    	   lightType="Three Color Traffic Light";
		       }else if( light.getType()==2) {
		    	   lightType="Single Color Traffic Light";
		       }else if( light.getType()==3) {
		    	   lightType="Bicycle Traffic Light";
		       }
		       
		       	setIcon(icon);
		       	setText(light.getId()+" "+lightType+" "+light.getStreet()+" "+light.getStreetNumber());
		       	return this;
		    }
}
	
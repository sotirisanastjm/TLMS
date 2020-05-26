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

		       TrafficLight light = (TrafficLight)value;
		        setText(light.getId()+" "+light.getType()+" "+light.getStreet()+" "+light.getStreetNumber()+" "+light.getColor());


		        return this;
		    }
}

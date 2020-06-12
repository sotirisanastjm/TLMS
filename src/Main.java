//To ena kommati me thn diasyndesh twn fanariwn den kataferame na to ylopoihsoyme

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static Registry TrafficLightList = new Registry();
	static AdminRegistry AdminList = new AdminRegistry();
	private static ObjectInputStream ois;
	
	public static void main(String[] args) {
		
		try {
			readFile();//Reads the data from the TrafficList.dat file to use previously saved Traffic LIghts
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		new LoginGui();
		
	}
	
	
	 public static void readFile() throws ClassNotFoundException, IOException {
         ois = new ObjectInputStream(new FileInputStream("TrafficList.dat"));
         @SuppressWarnings("unchecked")
		List<Object> input = (List<Object>) ois.readObject();
         List<Object> checkList = new ArrayList<>();
         // this will contain the list of the objects
         for (Object l : input) {
        	 checkList.add(l.getClass().getSimpleName());
             if (l instanceof ThreeColorTrafficLight) {
            	 ThreeColorTrafficLight app = (ThreeColorTrafficLight) l;
            	 TrafficLightList.addTrafficLight(app);
             }
             if (l instanceof SingleColorTrafficLight) {
            	 SingleColorTrafficLight app = (SingleColorTrafficLight) l;
            	 TrafficLightList.addTrafficLight(app);
             }
             if (l instanceof PedestrianTrafficLight) {
            	 PedestrianTrafficLight app = (PedestrianTrafficLight) l;
            	 TrafficLightList.addTrafficLight(app);
             }
             if (l instanceof BicycleTrafficLight) {
            	 BicycleTrafficLight app = (BicycleTrafficLight) l;
            	 TrafficLightList.addTrafficLight(app);

             }
         }
        
         ois.close();
     }
}

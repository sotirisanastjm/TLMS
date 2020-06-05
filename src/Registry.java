import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Registry {
	
	private ArrayList<TrafficLight> TrafficLightList;
	
	
	public Registry() {
		
		this.TrafficLightList = new ArrayList<TrafficLight>();
		
	}
	
	public void addTrafficLight( TrafficLight aTrafficLight) {
		boolean exists=false;
		for(TrafficLight a:TrafficLightList) {
		if(a.getId()== aTrafficLight.getId())		
			exists=true;
		}
		if(!exists) {
			TrafficLightList.add(aTrafficLight);
		}
	}
	
	public TrafficLight getTrafficLight(int anId) {
		for(TrafficLight trafficLight: TrafficLightList) {
			if(trafficLight.getId() == anId)
				return trafficLight;
		}
		return null;
	}
	
	public ArrayList<TrafficLight> getList() {
		return TrafficLightList;
	}
	
	public void sortType() {
		
		TrafficLight temp;
		for(int i=0;i<TrafficLightList.size();i++) {
			for(int j=1;j<(TrafficLightList.size() - i);j++) {
				if(TrafficLightList.get(j-1).getType() > TrafficLightList.get(j).getType()) {
					temp = TrafficLightList.get(j-1);  
                    TrafficLightList.set(j-1, TrafficLightList.get(j));  
                    TrafficLightList.set(j, temp); 
				}
			}
		}
		
	}
	
	public void sortId() {
		
		TrafficLight temp;
		for(int i=0;i<TrafficLightList.size();i++) {
			for(int j=1;j<(TrafficLightList.size() - i);j++) {
				if(TrafficLightList.get(j-1).getId() > TrafficLightList.get(j).getId()) {
					temp = TrafficLightList.get(j-1);  
                    TrafficLightList.set(j-1, TrafficLightList.get(j));  
                    TrafficLightList.set(j, temp); 
				}
			}
		}
		
	}
	
	public TrafficLight find(int id) {
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getId() == id) {
				return TrafficLightList.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<TrafficLight> findPrev(int id){
		
		ArrayList<TrafficLight> TrafficLightPrev = new ArrayList<>();
		TrafficLight currentTrafficLight = this.find(id);
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getStreet() == currentTrafficLight.getStreet() && TrafficLightList.get(i).getStreetNumber() < currentTrafficLight.getStreetNumber() && TrafficLightList.get(i).getType() == currentTrafficLight.getType()) {
				TrafficLightPrev.add(TrafficLightList.get(i));
			}
		}
		
		TrafficLight temp;
		for(int i=0;i<TrafficLightPrev.size();i++) {
			for(int j=1;j<(TrafficLightPrev.size() - i);j++) {
				if(TrafficLightPrev.get(j-1).getStreetNumber() < TrafficLightPrev.get(j).getStreetNumber()) {
					temp = TrafficLightPrev.get(j-1);  
					TrafficLightPrev.set(j-1, TrafficLightPrev.get(j));  
                    TrafficLightPrev.set(j, temp); 
				}
			}
		}
		return TrafficLightPrev;
	}
	
	public ArrayList<TrafficLight> findNext(int id){
		
		ArrayList<TrafficLight> TrafficLightNext = new ArrayList<>();
		TrafficLight currentTrafficLight = this.find(id);
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getStreet() == currentTrafficLight.getStreet() && TrafficLightList.get(i).getStreetNumber() > currentTrafficLight.getStreetNumber() && TrafficLightList.get(i).getType() == currentTrafficLight.getType()) {
				TrafficLightNext.add(TrafficLightList.get(i));
			}
		}
		
		TrafficLight temp;
		for(int i=0;i<TrafficLightNext.size();i++) {
			for(int j=1;j<(TrafficLightNext.size() - i);j++) {
				if(TrafficLightNext.get(j-1).getStreetNumber() > TrafficLightNext.get(j).getStreetNumber()) {
					temp = TrafficLightNext.get(j-1);  
					TrafficLightNext.set(j-1, TrafficLightNext.get(j));  
					TrafficLightNext.set(j, temp); 
				}
			}
		}
		return TrafficLightNext;
	}
	
	public void create(int id, int type, String street, int streetNumber, String color, boolean sign, boolean crosswalk) {
		
		TrafficLight newTrafficLight = null;
		if(type == 0) {
			newTrafficLight = new PedestrianTrafficLight(id, 0, street, streetNumber, color, sign, crosswalk);
		} else if(type == 1) {
			newTrafficLight = new ThreeColorTrafficLight(id, 1, street, streetNumber, color, sign, crosswalk);
		} else if(type == 2) {
			newTrafficLight = new SingleColorTrafficLight(id, 2, street, streetNumber, color, sign, crosswalk);
		} else if(type == 3) {
			newTrafficLight = new BicycleTrafficLight(id, 3, street, streetNumber, color, sign, crosswalk);
		}
		TrafficLightList.add(newTrafficLight);
		
	}
	
	public void delete(int id) {
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getId() == id) {
				TrafficLightList.remove(TrafficLightList.get(i));
			}
		}
	}
	
	public void changeType(int id, int newType) {
		
		TrafficLight currentTrafficLight = this.find(id);
		TrafficLight newTrafficLight = null;
		
		if(newType == 0) {
			newTrafficLight = new PedestrianTrafficLight(currentTrafficLight.getId(), 0, currentTrafficLight.getStreet(), currentTrafficLight.getStreetNumber(), currentTrafficLight.getColor(), currentTrafficLight.isSign(), currentTrafficLight.isCrosswalk());
		} else if(newType == 1) {
			newTrafficLight = new ThreeColorTrafficLight(currentTrafficLight.getId(), 1, currentTrafficLight.getStreet(), currentTrafficLight.getStreetNumber(), currentTrafficLight.getColor(), currentTrafficLight.isSign(), currentTrafficLight.isCrosswalk());
		} else if(newType == 2) {
			newTrafficLight = new SingleColorTrafficLight(currentTrafficLight.getId(), 2, currentTrafficLight.getStreet(), currentTrafficLight.getStreetNumber(), "yellow", currentTrafficLight.isSign(), currentTrafficLight.isCrosswalk());
		} else if(newType == 3) {
			newTrafficLight = new BicycleTrafficLight(currentTrafficLight.getId(), 3, currentTrafficLight.getStreet(), currentTrafficLight.getStreetNumber(), currentTrafficLight.getColor(), currentTrafficLight.isSign(), currentTrafficLight.isCrosswalk());
		}
		
		for(int i=0;i<TrafficLightList.size();i++) {
			if(TrafficLightList.get(i).getId() == currentTrafficLight.getId()) {
				TrafficLightList.set(i, newTrafficLight);
			}
		}
	}
	
	
    public static void writeToFile(List<TrafficLight> lights) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("TrafficList.txt"));
        os.writeObject(lights);
        os.close();

    }
 
    public static TrafficLight ReadObjectFromFile(String filepath) {
 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            TrafficLight obj = (TrafficLight) objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
}

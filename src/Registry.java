//the management of the Traffic Light List
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Registry {
	
	private ArrayList<TrafficLight> TrafficLightList;
	
	
	public Registry() {
		
		this.TrafficLightList = new ArrayList<TrafficLight>();
		
	}
	//adds a new traffic light to the list
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
	//gets and Id and returns a traffic light 
	public TrafficLight getTrafficLight(int anId) {
		for(TrafficLight trafficLight: TrafficLightList) {
			if(trafficLight.getId() == anId)
				return trafficLight;
		}
		return null;
	}
	//returns the whole list
	public ArrayList<TrafficLight> getList() {
		return TrafficLightList;
	}
	//sorts the list by type ascending
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
	//sorts the list by Id ascending
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
	//finds previous traffic lights based on street, street number and type
	public ArrayList<TrafficLight> findPrev(int id){
		
		ArrayList<TrafficLight> TrafficLightPrev = new ArrayList<>();
		TrafficLight currentTrafficLight = this.find(id);
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getStreet().equals(currentTrafficLight.getStreet()) && TrafficLightList.get(i).getStreetNumber() < currentTrafficLight.getStreetNumber() && TrafficLightList.get(i).getType() == currentTrafficLight.getType()) {
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
	//finds next traffic lights based on street, street number and type
	public ArrayList<TrafficLight> findNext(int id){
		
		ArrayList<TrafficLight> TrafficLightNext = new ArrayList<>();
		TrafficLight currentTrafficLight = this.find(id);
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getStreet().equals( currentTrafficLight.getStreet()) && TrafficLightList.get(i).getStreetNumber() > currentTrafficLight.getStreetNumber() && TrafficLightList.get(i).getType() == currentTrafficLight.getType()) {
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
	//gets info and creates a new traffic Light
	public void create(int id, int type, String street, int streetNumber, String color, boolean sign, boolean crosswalk) {
		
		TrafficLight newTrafficLight = null;
		if(type == 0) {
			newTrafficLight = new PedestrianTrafficLight(id, 0, street, streetNumber, color, sign, crosswalk);
		} else if(type == 1) {
			newTrafficLight = new ThreeColorTrafficLight(id, 1, street, streetNumber, color, sign, crosswalk);
		} else if(type == 2) {
			newTrafficLight = new SingleColorTrafficLight(id, 2, street, streetNumber, "yellow", sign, crosswalk);
		} else if(type == 3) {
			newTrafficLight = new BicycleTrafficLight(id, 3, street, streetNumber, color, sign, crosswalk);
		}
		TrafficLightList.add(newTrafficLight);
		
	}
	//deletes a traffic light from the list
	public void delete(int id) {
		
		for(int i=0;i<TrafficLightList.size();i++) {
			
			if(TrafficLightList.get(i).getId() == id) {
				TrafficLightList.remove(TrafficLightList.get(i));
			}
		}
	}
	//changes a traffic light's type
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
	
	//writes the traffic light list to a file
    public static void writeToFile(List<TrafficLight> lights) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("TrafficList.dat"));
        os.writeObject(lights);
        os.close();

    }
    
    
}

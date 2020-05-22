
public class PedestrianTrafficLight extends TrafficLight{

	public PedestrianTrafficLight(int id, int type, String street, int streetNumber, String color) {
		super(id, type, street, streetNumber, color);
	}
	
	public void PrintMyType() {
		System.out.println("This is a Pedestrian Traffic Light");
	}

}

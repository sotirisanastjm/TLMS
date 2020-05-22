
public class BicycleTrafficLight extends TrafficLight{
	
	public BicycleTrafficLight(int id, int type, String street, int streetNumber, String color) {
		super(id, type, street, streetNumber, color);
	}
	
	public void PrintMyType() {
		System.out.println("This is a Bicycle Traffic Light");
	}


}


public class SingleColorTrafficLight extends TrafficLight{
	
	public SingleColorTrafficLight(int id, int type, String street, int streetNumber, String color) {
		super(id, type, street, streetNumber, color);
	}
	
	public void PrintMyType() {
		System.out.println("This is a Single Color Traffic Light");
	}

}

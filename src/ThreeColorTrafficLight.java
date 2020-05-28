
public class ThreeColorTrafficLight extends TrafficLight{
	
	public ThreeColorTrafficLight(int id, int type, String street, int streetNumber, String color) {
		super(id, type, street, streetNumber, color);
	}
	
	public void PrintMyType() {
		System.out.println("This is a Three Color Traffic Light");
	}

}

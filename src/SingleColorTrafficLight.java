
public class SingleColorTrafficLight extends TrafficLight{
	
	public SingleColorTrafficLight(int id, int type, String street, int streetNumber, String color,boolean sign, boolean crosswalk) {
		super(id, type, street, streetNumber, color, sign, crosswalk);
	}
	
	public void PrintMyType() {
		System.out.println("This is a Single Color Traffic Light");
	}

}

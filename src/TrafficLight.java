
public abstract class TrafficLight {
	
	private int id;
	private int type;
	private String street;
	private int streetNumber;
	private String color;
	
	public TrafficLight(int id, int type, String street, int streetNumber, String color) { /*το color ενδεικτικα*/
		
		this.id = id;
		this.type = type;
		this.street = street;
		this.streetNumber = streetNumber;
		this.color = color;
			
	}
	
	public int getId() {
		return id;
	}
	
	public int getType() {
		return type;
	}
	
	public String getStreet() {
		return street;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	
	public String getColor() {
		return color;
	}
	
	public void printMyType() {}

}

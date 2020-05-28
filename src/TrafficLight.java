public abstract class TrafficLight {
	
	public void setId(int id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setColor(String color) {
		this.color = color;
	}

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

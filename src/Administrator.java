//This class is for Objects of type Administrator used in AdminRegistry
public class Administrator {

	private String username;
	private String password;
	
	public Administrator(String username , String password ) {
		this.username=username;
		this.password=password;

	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public void printinfo() {
		System.out.println(username+password);
	}
}

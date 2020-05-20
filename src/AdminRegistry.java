import java.io.*;
import java.util.*;



public class AdminRegistry {

	private List<Administrator> AdminList;
	private Boolean adminFlag;
	private String currentusername;
	private String currentpassword;
	
	
	
	public AdminRegistry() {
		Administrator admin;
		AdminList=new ArrayList<>();
		File file = new File("AdminList.dat");
		try {
			Scanner reader = new Scanner(file);
			String username;
			String password="";
			while(reader.hasNextLine()) {
				username=password;
				password=reader.next();
				if(username.equals("Username:")) {
					username=password;
					password=reader.next();
					password=reader.next();
					admin=new Administrator(username,password);
					AdminList.add(admin);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR IN ADMIN REGISTRY");
		}
		
		currentusername="";
		currentpassword="";
		adminFlag=false;
		
		
	}

	public Boolean getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(Boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getCurrentusername() {
		return currentusername;
	}

	public void setCurrentusername(String currentusername) {
		this.currentusername = currentusername;
	}

	public String getCurrentpassword() {
		return currentpassword;
	}

	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
	
	public Administrator getCredentials() {
		
		return new Administrator(currentusername,currentpassword);
		
			
	}
	public void isAdmin(String username , String password) {
		for(int i = 0;i<AdminList.size();i++) {
			if(username.equals(AdminList.get(i).getusername())&&password.equals(AdminList.get(i).getpassword())) {
				this.currentusername=username;
				this.currentpassword=password;
				adminFlag=true;
				break;
			}
		}
	}
			

	
}

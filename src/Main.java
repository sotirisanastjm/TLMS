
public class Main {
	
	static Registry TrafficLightList = new Registry();/*Δημιουργεια αρχειου φαναριων*/
	static AdminRegistry AdminList = new AdminRegistry();/*Δημιουργεια αρχειου διαχειριστων(δοκιμαστικα)-ειναι αδειο*/
	/*Τα τοποθετησαμε εδω ωστε να το βλεπουν ολες οι κλασεις (GUI) που χρεαιζεται να κανουν επαληθευση διαχειριστη και λειτεουργιες του Registry*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginGui();
	}

}


public class Main {
	
	static Registry TrafficLightList = new Registry();/*Î”Î·Î¼Î¹Î¿Ï…Ï�Î³ÎµÎ¹Î± Î±Ï�Ï‡ÎµÎ¹Î¿Ï… Ï†Î±Î½Î±Ï�Î¹Ï‰Î½*/
	static AdminRegistry AdminList = new AdminRegistry();/*Î”Î·Î¼Î¹Î¿Ï…Ï�Î³ÎµÎ¹Î± Î±Ï�Ï‡ÎµÎ¹Î¿Ï… Î´Î¹Î±Ï‡ÎµÎ¹Ï�Î¹ÏƒÏ„Ï‰Î½(Î´Î¿ÎºÎ¹Î¼Î±ÏƒÏ„Î¹ÎºÎ±)-ÎµÎ¹Î½Î±Î¹ Î±Î´ÎµÎ¹Î¿*/
	/*Î¤Î± Ï„Î¿Ï€Î¿Î¸ÎµÏ„Î·ÏƒÎ±Î¼Îµ ÎµÎ´Ï‰ Ï‰ÏƒÏ„Îµ Î½Î± Ï„Î¿ Î²Î»ÎµÏ€Î¿Ï…Î½ Î¿Î»ÎµÏ‚ Î¿Î¹ ÎºÎ»Î±ÏƒÎµÎ¹Ï‚ (GUI) Ï€Î¿Ï… Ï‡Ï�ÎµÎ±Î¹Î¶ÎµÏ„Î±Î¹ Î½Î± ÎºÎ±Î½Î¿Ï…Î½ ÎµÏ€Î±Î»Î·Î¸ÎµÏ…ÏƒÎ· Î´Î¹Î±Ï‡ÎµÎ¹Ï�Î¹ÏƒÏ„Î· ÎºÎ±Î¹ Î»ÎµÎ¹Ï„ÎµÎ¿Ï…Ï�Î³Î¹ÎµÏ‚ Ï„Î¿Ï… Registry*/
	PedestrianTrafficLight gg1 =new PedestrianTrafficLight(0, 0, null, 0, null);
	PedestrianTrafficLight gg2 =new PedestrianTrafficLight(0, 0, null, 0, null);
	PedestrianTrafficLight gg3 =new PedestrianTrafficLight(0, 0, null, 0, null);
	PedestrianTrafficLight gg4 =new PedestrianTrafficLight(0, 0, null, 0, null);
	PedestrianTrafficLight gg5 =new PedestrianTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh1 =new BicycleTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh2 =new BicycleTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh3 =new BicycleTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh4 =new BicycleTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh5 =new BicycleTrafficLight(0, 0, null, 0, null);
	BicycleTrafficLight gh6 =new BicycleTrafficLight(0, 0, null, 0, null);
	ThreeColorTrafficLight gi1 =new ThreeColorTrafficLight(0, 0, null, 0, null);
	ThreeColorTrafficLight gi2 =new ThreeColorTrafficLight(0, 0, null, 0, null);
	ThreeColorTrafficLight gi3 =new ThreeColorTrafficLight(0, 0, null, 0, null);
	ThreeColorTrafficLight gi4 =new ThreeColorTrafficLight(0, 0, null, 0, null);
	ThreeColorTrafficLight gi5 =new ThreeColorTrafficLight(0, 0, null, 0, null);
	SingleColorTrafficLight gj1 =new SingleColorTrafficLight(0, 0, null, 0, null);
	SingleColorTrafficLight gj2 =new SingleColorTrafficLight(0, 0, null, 0, null);
	SingleColorTrafficLight gj3 =new SingleColorTrafficLight(0, 0, null, 0, null);
	SingleColorTrafficLight gj4 =new SingleColorTrafficLight(0, 0, null, 0, null);
	SingleColorTrafficLight gj5 =new SingleColorTrafficLight(0, 0, null, 0, null);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginGui();
		
	}

}

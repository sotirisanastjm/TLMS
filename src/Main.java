
public class Main {
	
	public static Registry TrafficLightList = new Registry();/*Î”Î·Î¼Î¹Î¿Ï…Ï�Î³ÎµÎ¹Î± Î±Ï�Ï‡ÎµÎ¹Î¿Ï… Ï†Î±Î½Î±Ï�Î¹Ï‰Î½*/
	static AdminRegistry AdminList = new AdminRegistry();/*Î”Î·Î¼Î¹Î¿Ï…Ï�Î³ÎµÎ¹Î± Î±Ï�Ï‡ÎµÎ¹Î¿Ï… Î´Î¹Î±Ï‡ÎµÎ¹Ï�Î¹ÏƒÏ„Ï‰Î½(Î´Î¿ÎºÎ¹Î¼Î±ÏƒÏ„Î¹ÎºÎ±)-ÎµÎ¹Î½Î±Î¹ Î±Î´ÎµÎ¹Î¿*/
	/*Î¤Î± Ï„Î¿Ï€Î¿Î¸ÎµÏ„Î·ÏƒÎ±Î¼Îµ ÎµÎ´Ï‰ Ï‰ÏƒÏ„Îµ Î½Î± Ï„Î¿ Î²Î»ÎµÏ€Î¿Ï…Î½ Î¿Î»ÎµÏ‚ Î¿Î¹ ÎºÎ»Î±ÏƒÎµÎ¹Ï‚ (GUI) Ï€Î¿Ï… Ï‡Ï�ÎµÎ±Î¹Î¶ÎµÏ„Î±Î¹ Î½Î± ÎºÎ±Î½Î¿Ï…Î½ ÎµÏ€Î±Î»Î·Î¸ÎµÏ…ÏƒÎ· Î´Î¹Î±Ï‡ÎµÎ¹Ï�Î¹ÏƒÏ„Î· ÎºÎ±Î¹ Î»ÎµÎ¹Ï„ÎµÎ¿Ï…Ï�Î³Î¹ÎµÏ‚ Ï„Î¿Ï… Registry*/
	
	public static void main(String[] args) {
		
		TrafficLight tl1 =new ThreeColorTrafficLight(100, 1, "Tsimiski", 5, "red", false, false);
		TrafficLight tl2 =new ThreeColorTrafficLight(101, 1, "Tsimiski", 7, "red", true, false);
		TrafficLight gi1 =new ThreeColorTrafficLight(102, 1, "Aristotelous", 1, "green", false, false);//nai gia osous thn eidan GTA sthn aristotelous na pathsoyn pezous
		TrafficLight gi2 =new ThreeColorTrafficLight(103, 1, "Aristotelous", 2, "green", false, false);
		TrafficLight gi3 =new ThreeColorTrafficLight(104, 1, "Aristotelous", 3, "green", false, false);
		TrafficLight gi4 =new ThreeColorTrafficLight(105, 1, "Aristotelous", 4, "green", false, false);
		TrafficLight gi5 =new ThreeColorTrafficLight(106, 1, "Aristotelous", 5, "green", false, false);
		TrafficLight gg1 =new PedestrianTrafficLight(107, 0, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gg2 =new PedestrianTrafficLight(108, 0, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gg3 =new PedestrianTrafficLight(109, 0, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gg4 =new PedestrianTrafficLight(110, 0, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gg5 =new PedestrianTrafficLight(111, 0, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh1 =new BicycleTrafficLight(112, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh2 =new BicycleTrafficLight(113, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh3 =new BicycleTrafficLight(114, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh4 =new BicycleTrafficLight(115, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh5 =new BicycleTrafficLight(116, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gh6 =new BicycleTrafficLight(117, 3, "Ethnikhs amynhs", 0, "red", false, false);
		TrafficLight gj1 =new SingleColorTrafficLight(118, 2, "Ethnikhs amynhs", 0, "yellow", false, false);
		TrafficLight gj2 =new SingleColorTrafficLight(119, 2, "Ethnikhs amynhs", 0, "yellow", false, false);
		TrafficLight gj3 =new SingleColorTrafficLight(120, 2, "Ethnikhs amynhs", 0, "yellow", false, false);
		TrafficLight gj4 =new SingleColorTrafficLight(121, 2, "Ethnikhs amynhs", 0, "yellow", false, false);
		TrafficLight gj5 =new SingleColorTrafficLight(122, 2, "Ethnikhs amynhs", 0, "yellow", false, false);
		
		TrafficLightList.addTrafficLight(tl1);
		TrafficLightList.addTrafficLight(tl2);
		TrafficLightList.addTrafficLight(gg1);
		TrafficLightList.addTrafficLight(gg2);
		TrafficLightList.addTrafficLight(gg3);
		TrafficLightList.addTrafficLight(gg4);
		TrafficLightList.addTrafficLight(gg5);
		TrafficLightList.addTrafficLight(gh1);
		TrafficLightList.addTrafficLight(gh2);
		TrafficLightList.addTrafficLight(gh3);
		TrafficLightList.addTrafficLight(gh4);
		TrafficLightList.addTrafficLight(gh5);
		TrafficLightList.addTrafficLight(gh6);
		TrafficLightList.addTrafficLight(gi1);
		TrafficLightList.addTrafficLight(gi2);
		TrafficLightList.addTrafficLight(gi3);
		TrafficLightList.addTrafficLight(gi4);
		TrafficLightList.addTrafficLight(gi5);
		TrafficLightList.addTrafficLight(gj1);
		TrafficLightList.addTrafficLight(gj2);
		TrafficLightList.addTrafficLight(gj3);
		TrafficLightList.addTrafficLight(gj4);
		TrafficLightList.addTrafficLight(gj5);
		
		
		
		new LoginGui();

	}

}

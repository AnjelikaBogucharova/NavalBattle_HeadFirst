package game_naval_battle;

import java.util.ArrayList;

public class Ships {
	private ArrayList<String> locationShip;
	private String name;

	public void setLocationShips(ArrayList<String> loc){
		locationShip = loc;
	}

	public void setName(String n){
		name = n;
	}

	public String checkYourSelf(String userInput){
		String result = "Мимо";
		int index = locationShip.indexOf(userInput);
		if (index >= 0){
			locationShip.remove(index);

			if(locationShip.isEmpty()){
				result = "Потопил";
				System.out.println("Вы потопили корабль " + name);
			}else {
				result = "Попал";
			}
		}
		return result;
	}
}
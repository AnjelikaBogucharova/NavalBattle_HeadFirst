package game_naval_battle;

import java.util.ArrayList;

public class MainGame {

	private GameHelper helper = new GameHelper();
	private ArrayList<Ships> shipsList = new ArrayList<Ships>();
	private int numOfGuesses = 0;

	private  void  setUpGame(){
		Ships one = new Ships();
		one.setName("ShipOne");
		Ships two = new Ships();
		two.setName("ShipTwo");
		Ships three = new Ships();
		three.setName("ShipTree");
		shipsList.add(one);
		shipsList.add(two);
		shipsList.add(three);

		System.out.println("Ваша цель потопить три корабля");
		System.out.println("ShipOne, ShipTwo, ShipThree");
		System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        System.out.println("По вертикали доступны ячейки: a, b, c, d, e, f, g");
        System.out.println("По горизонтали доступны ячейки: 0, 1, 2, 3, 4, 5, 6");

		for(Ships shipToSet : shipsList){
			ArrayList<String> newLocation = helper.placeShips(3);
			shipToSet.setLocationShips(newLocation);
		}
	}

	private  void  startPlaying(){
		while(!shipsList.isEmpty()){
			String userGuess = helper.getUserInput("Сделайте ход");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private  void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result = "Мимо";
		for(Ships shipToTest : shipsList){
			result = shipToTest.checkYourSelf(userGuess);
			if(result.equals("Попал")){
				break;
			}
			if(result.equals("Потопил")){
				shipsList.remove(shipToTest);
				break;
			}
		}
		System.out.println(result);
	}

	private  void  finishGame(){
		System.out.println("Все коробли ушли ко дну! Ваше золото теперь ничего не стоит.");
		if(numOfGuesses<=18){
			System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
			System.out.println("Вы успели выбраться до того, как ваше золото утонуло.");
		}else{
			System.out.println("Это занял у вас довольно много времени: " + numOfGuesses + " попыток.");
			System.out.println("Рыбы водят хороводы вокруг вашего золота.");
		}
	}

	public static void  main(String[] args){
		MainGame game = new MainGame();
		game.setUpGame();
		game.startPlaying();
	}
}
package gameMenu;

import numberGuesser.NumberGuesser;
import ui.Menus;
import ui.PlayerChoice;

public class MenuHandler {
	NumberGuesser guesser;
	PlayerChoice menu;
	
	
	public MenuHandler() {
		guesser = new NumberGuesser();
		menu = new PlayerChoice();
	}
	
	public String showMainMenu() {
		return menu.choose(Menus.mainMenu());
	}
	
	public boolean menuLoop(String choice) {
		switch(choice) {
		case "Number Guesser" -> {NumberGuesser.guessing();
								return true;}
		case "Exit" -> {return false;}
		default -> {System.out.println("Error");
					return false;}
		}
	}
}

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
		if (choice == null) {
			System.out.println("Not a valid number!");
			return true;
		} else {
			switch (choice) {
				case "Number Guesser" -> {
					guesser.game();
					return true;
				}
				case "Exit" -> {
					return false;
				}
				default -> {
					System.out.println("Error");
					return false;
				}
			}
		}
	}
}

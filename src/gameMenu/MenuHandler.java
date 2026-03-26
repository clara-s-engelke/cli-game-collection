package gameMenu;

import numberGuesser.NumberGuesser;
import ui.Menus;
import ui.PlayerChoice;

public class MenuHandler {
	private final NumberGuesser guesser;
	private final PlayerChoice menu;
	
	
	public MenuHandler(PlayerChoice menu) {
		guesser = new NumberGuesser(menu);
		this.menu = menu;
	}
	
	public String showMainMenu() {
		return menu.choose(Menus.mainMenu());
	}
	
	public boolean menuLoop(String choice) {
			switch (choice) {
				case "Number Guesser" -> {
					guesser.start();
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

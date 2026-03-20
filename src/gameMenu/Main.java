package gameMenu;

public class Main {
	public static void main(String[] args) {
		MenuHandler menu = new MenuHandler();
		boolean running = true;
		
		while(running) {
			String choice = menu.showMainMenu();
			running = menu.menuLoop(choice);
			System.out.println("\n----------\n");
		}
		System.out.println("Bye Bye!");
		
	}
}

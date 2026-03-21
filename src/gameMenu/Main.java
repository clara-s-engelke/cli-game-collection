package gameMenu;

public class Main {
    public static void main(String[] args) {
        MenuHandler menu = new MenuHandler();
        boolean running;
        do {
            String choice = menu.showMainMenu();
            running = menu.menuLoop(choice);
            System.out.println("\n----------\n");
        }while(running);

        System.out.println("Bye Bye!");

    }




}

package gameMenu;

import ui.PlayerChoice;
import ui.PlayerInput;

public class Main {
    static PlayerInput input;
    static PlayerChoice pc;
    static MenuHandler menu;
    public static void main(String[] args) {
        init();
        boolean running;
        do {
            String choice = menu.showMainMenu();
            running = menu.menuLoop(choice);
            System.out.println("\n----------\n");
        }while(running);

        System.out.println("Bye Bye!");

    }

    private static void init(){
        input = new PlayerInput();
        pc = new PlayerChoice(input);
        menu = new MenuHandler(pc);
    }




}

package ui;

import java.util.List;

public class PlayerChoice {
	private final PlayerInput input;
	
	public PlayerChoice() {
		input = new PlayerInput();
	}
	
	public <T> T choose(List<T> options) {
		int i = 1;
		for(T option : options) {
			System.out.println(i + " - " + option);
			i++;
		}
		System.out.print("Please choose a number: ");
		int choice = input.readInt()-1;
		if(input.inBounds(0, options.size(), choice)) {
			return options.get(choice);
		} else {
			return null;
		}
	}

	public PlayerInput getInput(){
		return input;
	}
}

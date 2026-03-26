package ui;

import java.util.List;

public class PlayerChoice {
	private final PlayerInput input;
	
	public PlayerChoice(PlayerInput input) {
		this.input = input;
	}
	
	public <T> T choose(List<T> options) {
		if (options.isEmpty()) {
			System.out.println("No options available");
			throw new IllegalArgumentException("options must not be empty!");
		}

		int i = 1;
		for(T option : options) {
			System.out.println(i + " - " + option);
			i++;
		}
		while(true){
		System.out.print("Please choose a number: ");
		int choice = input.readInt()-1;
		if(input.inBounds(0, options.size(), choice)) {
			return options.get(choice);
		} else{
			System.out.println("Not a valid number! ");
		}
		}
	}

	public PlayerInput getInput(){
		return input;
	}
}

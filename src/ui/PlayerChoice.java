package ui;

import java.util.List;
import java.util.Optional;

public class PlayerChoice {
	private final PlayerInput input;
	
	public PlayerChoice(PlayerInput input) {
		this.input = input;
	}
	
	public <T> Optional<T> choose(List<T> options) {
		if (options.isEmpty()) {
			System.out.println("No options available");
			throw new IllegalArgumentException("options must not be empty!");
		}

		int i = 1;
		for(T option : options) {
			System.out.println(i + " - " + option);
			i++;
		}
		System.out.println(i + " - EXIT");
		while(true){
		System.out.print("Please choose a number: ");
		int choice = input.readInt()-1;
		if(choice == options.size()){
			return Optional.empty();
		}
		if(input.inBounds(0, options.size(), choice)) {
			return Optional.of(options.get(choice));
		} else{
			System.out.println("Not a valid number! ");
		}
		}
	}

	public PlayerInput getInput(){
		return input;
	}
}

package numberGuesser;

import ui.PlayerChoice;

public class NumberGuesser {
	private final PlayerChoice player;

	public NumberGuesser(){
		player = new PlayerChoice();
	}

	public void guessing() {
		int secretNum = (int) (Math.random()*100);
		boolean running = true;
		int tries = 0;
		do{
			tries++;
			System.out.print("What's your guess?");
			int guess = player.getInput().readInt();
			if (guess < secretNum) {
				System.out.println("Number too small");
				System.out.println("You have " + (10 - tries)  +  " tries left!");
			} else if (guess > secretNum) {
				System.out.println("Number too big");
				System.out.println("You have " + (10 - tries)  +  " tries left!");
			} else{
				System.out.println("You guessed the number in " + tries + " tries!");
				running = false;
			}
		}while(running && tries < 10);
	}
}

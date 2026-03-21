package numberGuesser;

import ui.PlayerChoice;

public class NumberGuesser {
	private final PlayerChoice player;

	public NumberGuesser(){
		player = new PlayerChoice();
	}

	public void game(){
		int secretNum = (int) (Math.random()*100);
		boolean running = true;
		int tries = 0;
		do{
			tries++;
			guessResult result = guessing(secretNum);
			if(result == null){
				tries--;
				System.out.println("Try Again!");
			} else if(result ==guessResult.TOO_SMALL) {
				System.out.println(guessResult.TOO_SMALL.print());
			} else if(result == guessResult.TOO_BIG) {
				System.out.println(guessResult.TOO_BIG.print());
			} else {
				System.out.println(guessResult.CORRECT.print());
				running = false;
			}
			if (result == guessResult.CORRECT) {
				System.out.println("You guessed the number in " + tries + " tries!");
			} else{
				System.out.println("You have " + (10 - tries) + " tries left.");
			}

		}while(running && tries < 10);
	}

	public guessResult guessing(int secretNum) {
			System.out.print("What's your guess?");
			int guess = player.getInput().readInt();
		if (guess == -1) {
			return null;
		}else if (guess < secretNum) {
				return guessResult.TOO_SMALL;
			} else if (guess > secretNum) {
				return guessResult.TOO_BIG;
			} else{
				return guessResult.CORRECT;
			}
	}
}

package numberGuesser;

import game.Game;
import ui.PlayerChoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberGuesser {
	private final PlayerChoice player;
	private final Map<Difficulty, Highscore> highscores;

	public NumberGuesser() {
		player = new PlayerChoice();
		highscores = new HashMap<>();
		for(Difficulty difficulty : Difficulty.values()){
			highscores.put(difficulty, new Highscore(difficulty.getMaxTries()));
		}
	}

	public void game() {
		Difficulty difficulty = setDifficulty();
		if(difficulty == Difficulty.EXIT)  return;
		int secretNum = (int) (Math.random() * difficulty.getMaxNum());
		boolean running;
		int tries = 0;

		do {
			running = round(secretNum);
			tries++;
			if (running) {
				System.out.println("You have " + (difficulty.getMaxTries() - tries) + " tries left!");
			}
		} while (running && tries < difficulty.getMaxTries());

		if (running) {
			System.out.println("You lose! The number was " + secretNum);
		} else {
			System.out.println("You won, congrats! You guessed the number in " + tries + " tries!");
			if (highscores.get(difficulty).isBetter(tries)) {
				System.out.println("That's a new high score for the difficulty " + difficulty);
				highscores.get(difficulty).update(tries);
			} else {
				System.out.println("Sorry, no new high score this time! The current highscore is: "
						+ highscores.get(difficulty).getScore());
			}
		}
	}

	private GuessResult guess(int secretNum) {
		System.out.print("What's your guess?");
		int guess = player.getInput().readInt();
		if (guess == -1) {
			return null;
		} else if (guess < secretNum) {
			return GuessResult.TOO_SMALL;
		} else if (guess > secretNum) {
			return GuessResult.TOO_BIG;
		} else {
			return GuessResult.CORRECT;
		}
	}

	private boolean round(int secretNum) {
		GuessResult result;
		do {
			result = guess(secretNum);
			if (result == null) System.out.println("Try Again!");
		} while (result == null);
		System.out.println(result.print());
		return result != GuessResult.CORRECT;
	}

	private Difficulty setDifficulty(){
		Difficulty difficulty;
		difficulty = player.choose(List.of(Difficulty.values()));
		return difficulty;
	}
}

package numberGuesser;

import game.Game;
import ui.PlayerChoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NumberGuesser implements Game {
	private final PlayerChoice player;
	private final Map<Difficulty, Highscore> highscores;

	private int secretNum;
	private int attempts;
	private boolean won;
	private Difficulty difficulty;


	public NumberGuesser(PlayerChoice player) {
		this.player = player;
		highscores = new HashMap<>();
		for(Difficulty difficulty : Difficulty.values()){
			highscores.put(difficulty, new Highscore(difficulty.getMaxTries()));
		}
	}

	@Override
	public String toString(){
		return "NUMBERGUESSER";
	}

	@Override
	public void start() {
		boolean run = init();
		if(!run){
			return;
		}
		printInstructions();
		while (!isGameOver()) {
			gameState();
			int num = guess();
			GuessResult result = getResult(num);
			handleResult(result);
		}
		end();
		reset();
	}

	@Override
	public void printInstructions() {
		System.out.println("This is a number guessing game");
		System.out.println("The idea is simple: guess the secret number.");
		System.out.println("After every guess, you'll get feedback on your guess" +
				" - was your number too big, too small or correct");
		System.out.println("You have a limited amount of attempts, depending on your difficulty");

	}

	private boolean init(){
		Optional<Difficulty> diff = setDifficulty();
		if (diff.isEmpty()) {
			return  false;
		} else{
			difficulty = diff.get();
		}
		secretNum = (int) (Math.random()*(difficulty.getMaxNum()+1));
		attempts = 0;
		won = false;
		return true;
	}

	private boolean isGameOver(){
		return (won || attempts >= difficulty.getMaxTries());
	}

	private void gameState(){
		if (attempts == 0) {
			System.out.println("The biggest possible number for your game is: " + difficulty.getMaxNum());
		}
		System.out.println("You have: " + (difficulty.getMaxTries() - attempts) + " left");
	}

	private int guess(){
		System.out.println("What is your guess?");
		return player.getInput().readInt();
	}

	private GuessResult getResult(int guess){
		attempts++;
		if(guess < secretNum){
			return GuessResult.TOO_SMALL;
		} else if(guess > secretNum){
			return GuessResult.TOO_BIG;
		} else{
			return GuessResult.CORRECT;
		}
	}

	private void handleResult(GuessResult result){
		System.out.println(result.print());
		if(result == GuessResult.CORRECT){
			won = true;
		}
	}

	private void end(){
		if (won) {
			System.out.println("Congratulations, you won in " + attempts + " attemps");
			if(checkHighscore()){
				System.out.println("Thats a new highscore for that difficulty!");
			} else{
				System.out.println("The highscore for this difficulty is: " + highscores.get(difficulty).getScore());
			}
		} else{
			System.out.println("You lost - what a shame, maybe next time :D");
		}
	}

	@Override
	public void reset() {
		won = false;
		attempts = 0;
		secretNum = -1;
	}

//Util
	private Optional<Difficulty> setDifficulty(){
		return player.choose(List.of(Difficulty.values()));
	}

	private boolean checkHighscore(){
		if(highscores.get(difficulty).isBetter(attempts)){
			highscores.get(difficulty).update(attempts);
			return true;
		} else{
			return false;
		}
	}
}

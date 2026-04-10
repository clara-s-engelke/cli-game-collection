package hangman;

import game.Game;
import ui.PlayerChoice;


public class Hangman implements Game {
    private State gameState;
    private HangmanController controller;
    private int mistakes;
    private int maxMistakes;
    private final PlayerChoice pc;


    public Hangman(PlayerChoice pc){
        this.pc = pc;
    }

    @Override
    public String toString(){
        return "Hangman";
    }

    @Override
    public void start() {
        init();
        boolean noExit = controller.setWord();
        if(!noExit){
            return;
        }
        while(gameState == State.RUNNING){
            controller.showStats(mistakes);
            char guess = controller.getPlayerGuess();
            boolean inWord = controller.isInWord(guess);
            if(inWord){
                controller.addToUsedLetters(guess);
                if(controller.fullWord()){
                    gameState = State.WON;
                }
            } else{
                if(controller.alreadyUsed(guess)){
                    continue;
                }
                controller.addToUsedLetters(guess);
                mistakes++;
                if(mistakes >= maxMistakes){
                    gameState = State.LOST;
                }
            }
        }
        controller.result(gameState.message());
    }

    @Override
    public void printInstructions() {

    }

    @Override
    public void reset() {

    }

    public void init(){
        gameState = State.RUNNING;
        mistakes = 0;
        maxMistakes = 9;
        controller = new HangmanController(pc);
    }
}

package hangman;

import game.Game;
import ui.PlayerChoice;

import java.util.ArrayList;
import java.util.List;

public class Hangman implements Game {
    String word;
    State gameState;
    List<Character> usedLetters;
    int mistakes;
    int maxMistakes;
    PlayerChoice pc;
    WordManager wm;

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
        word = wm.chooseWord();

    }

    @Override
    public void printInstructions() {

    }

    @Override
    public void reset() {

    }

    public void init(){
        gameState = State.RUNNING;
        usedLetters = new ArrayList<>();
        int mistakes = 0;
        int maxMistakes = 10;
        WordManager wm = new WordManager("assets/wordlist.txt");
    }
}

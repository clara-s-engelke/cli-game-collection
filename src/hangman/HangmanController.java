package hangman;

import assets.HangmanASCII;
import ui.PlayerChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HangmanController {
    private final PlayerChoice pc;
    private String word;
    private final WordManager wm;
    private final HangmanASCII art;
    private final List<Character> usedLetters;

    public HangmanController(PlayerChoice pc){
        this.pc = pc;
        wm = new WordManager("assets/wordlist.txt");
        usedLetters = new ArrayList<>();
        art = new HangmanASCII();
    }

    public boolean setWord(){
        wm.initWordList();
        Optional<String> category = chooseCategory();
        if(category.isEmpty()){
            return false;
        }
        word = wm.chooseWord(String.valueOf(category.get()));
        return true;
    }

    public Optional<String> chooseCategory(){
        System.out.println("What category do you want?");
        return pc.choose(wm.getCategories());
    }

    public char getPlayerGuess(){
        System.out.print("What is your guess? ");
        return pc.getInput().readLetter();
    }

    public boolean isInWord(char c){
        return(word.indexOf(c) >= 0);
    }

    public void addToUsedLetters(char c){
        if(!usedLetters.contains(c)) {
            usedLetters.add(c);
        }
    }

    public boolean fullWord(){
        boolean full = true;
        for(char c : word.toCharArray()){
            if (!usedLetters.contains(c)) {
                full = false;
                break;
            }
        }
        return full;
    }

    public void showStats(int i){
        showHangmanProgress(i);
        showWordProgress();
        showUsedLetters();
    }

    private void showWordProgress(){
        System.out.print("Your word: ");
        for(char c : word.toCharArray()){
            if(usedLetters.contains(c)){
                System.out.print(c);
            } else{
                System.out.print("_");
            }
        }
        System.out.println();
    }

    private void showHangmanProgress(int progress){
        System.out.println(art.getState(progress));
    }

    private void showUsedLetters(){
        System.out.print("Used Letters: ");
        for(char c : usedLetters){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void result(String s){
        System.out.println("The word was: " + word);
        System.out.println(s);
    }

    public boolean alreadyUsed(char c){
        return(usedLetters.contains(c));
    }
}

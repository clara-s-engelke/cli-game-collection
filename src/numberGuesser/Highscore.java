package numberGuesser;

public class Highscore {
    private final Difficulty difficulty;
    private int highscore;

    public Highscore(Difficulty difficulty, int score){
        this.difficulty = difficulty;
        this.highscore = score;
    }

    public boolean compare(int score){
        if(score < highscore){
            highscore = score;
            return true;
        } else{
            return false;
        }
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }
}

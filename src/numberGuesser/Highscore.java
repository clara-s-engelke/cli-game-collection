package numberGuesser;

public class Highscore {
    private int highscore;

    public Highscore(int score){
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

    public int getScore(){
        return highscore;
    }
}

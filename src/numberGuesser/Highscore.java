package numberGuesser;

public class Highscore {
    private int highscore;

    public Highscore(int score){
        this.highscore = score;
    }

    public boolean isBetter(int score){
       return score < highscore;
    }

    public void update(int score){
        highscore = score;
    }

    public int getScore(){
        return highscore;
    }
}

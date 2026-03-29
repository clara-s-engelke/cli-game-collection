package tictactoe;

public class ComputerPlayer implements Player{
    char symbol;

    public ComputerPlayer(char symbol){
        this.symbol = symbol;
    }

    public String toString(){
        return "Computer";
    }

    @Override
    public Field chooseMove() {
        int row = (int) (Math.random()*3);
        int col =(int) (Math.random()*3);
        return new Field(row, col);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}

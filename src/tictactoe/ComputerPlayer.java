package tictactoe;

public class ComputerPlayer implements Player{
    char symbol;

    public ComputerPlayer(char symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return "Computer";
    }

    @Override
    public int[] chooseMove() {
        int row = (int) (Math.random()*3);
        int col =(int) (Math.random()*3);
        return (new int[]{row, col});
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}

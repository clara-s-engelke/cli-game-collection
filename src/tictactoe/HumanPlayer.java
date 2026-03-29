package tictactoe;

import ui.PlayerChoice;

public class HumanPlayer implements Player {
    private final char symbol;
    private final int board;
    private final PlayerChoice choice;

    public HumanPlayer(char symbol, int board,  PlayerChoice choice){
        this.symbol = symbol;
        this.board = board;
        this.choice = choice;
    }

    public String toString(){
        return "Human";
    }

    @Override
    public Field chooseMove() {
        System.out.println("Player " + symbol + " please choose a field:");
        System.out.print("First, the line: ");
        int line = choice.getInput().readInBounds(0, board-1);
        System.out.print("Next, the column: ");
        int column = choice.getInput().readInBounds(0, board-1);
        return new Field(line, column);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}

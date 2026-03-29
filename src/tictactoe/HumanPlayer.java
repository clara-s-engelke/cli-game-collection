package tictactoe;

import ui.PlayerChoice;

public class HumanPlayer implements Player {
    private final char symbol;
    private final char[][] board;
    private final PlayerChoice choice;

    public HumanPlayer(char symbol, char[][] board,  PlayerChoice choice){
        this.symbol = symbol;
        this.board = board;
        this.choice = choice;
    }

    @Override
    public String toString(){
        return "Human";
    }

    @Override
    public int[] chooseMove() {
        System.out.println("Player " + symbol + " please choose a field:");
        System.out.print("First, the line: ");
        int line = choice.getInput().readInBounds(0, board.length-1);
        System.out.print("Next, the column: ");
        int column = choice.getInput().readInBounds(0, board[line].length-1);
        return new int[]{line, column};
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}

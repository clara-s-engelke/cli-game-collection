package tictactoe;

import game.Game;
import ui.PlayerChoice;

import java.util.Arrays;

public class TicTacToe implements Game {
    char[][] board;
    boolean won;
    int moves;
    final char LEER = '-';
    PlayerChoice choice;
    Player player1;
    Player player2;
    Player current;

    public TicTacToe(PlayerChoice player){
        choice = player;
    }

    @Override
    public String toString(){
        return "TICTACTOE";
    }
    @Override
    public void reset() {

    }

    @Override
    public void start() {
        init();
        printInstructions();
        System.out.println("\n");
        while( !won && moves < 9){
            showBoard();
            boolean invalid;
            do {
                int[] field = current.chooseMove();
                invalid = makeMove(field, current.getSymbol());
            }while(invalid);
            won = checkWon();
            moves++;
            current = (current == player1) ? player2 : player1;
        }
        if (won) {
            current = (current == player1) ? player2 : player1;
            System.out.println( "Congrats, Player " + current.getSymbol() + " wins!");
        } else{
            System.out.println("It's a tie - no winners today");
        }
    }

    @Override
    public void printInstructions() {
        System.out.println("This this the classic game of tic tac toe we all love");
        System.out.println("In a 3x3 grid, each player chooses one field and puts their symbol inside");
        System.out.println("The one who first gets three in a row - horizontally, vertically or diagonally - wins");
        System.out.println("This is what the field looks like: ");
        int m = 1;
        for(int i = 0; i<3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print( m + " | ");
                m++;
            }
            System.out.println();
        }
    }

    private void init(){
        board = new char[3][3];
        won = false;
        moves = 0;
        for (char[] chars : board) {
            Arrays.fill(chars, LEER);
        }
        player1 = new HumanPlayer('X', board, choice);
        player2 = new HumanPlayer('O', board, choice);
        if (Math.random() < 0.5) {
            current = player1;
        } else{
            current = player2;
        }
    }

    private void showBoard(){
        for (char[] chars : board) {
            System.out.print(" | ");
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }
    }

    private boolean makeMove(int[] field, char symbol){
        if(isEmpty(field)){
            board[field[0]][field[1]] = symbol;
            return false;
        } else{
            System.out.println("This field is not empty, please choose a different one");
            return true;
        }
    }

    private boolean isEmpty(int[] field){
        return (board[field[0]][field[1]] == LEER);
    }

    private boolean checkWon(){
        char s = current.getSymbol();
        for (char[] chars : board) {
            if (chars[0] == s && chars[1] == s && chars[2] == s) {
                return true;
            }
        }

        for(int col = 0; col < board.length; col++){
            if(board[0][col]==s && board[1][col]==s && board[2][col]==s){
                return true;
            }
        }

        return (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
                (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }
}

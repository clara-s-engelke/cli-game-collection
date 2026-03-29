package tictactoe;

import game.Game;
import ui.PlayerChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TicTacToe implements Game {
    private char[][] board;
    private final int BOARD_SIZE;
    private boolean won;
    private int moves;
    private final char LEER = '-';
    private final PlayerChoice choice;
    private Player player1;
    private Player player2;
    private Player current;

    public TicTacToe(PlayerChoice player){
        choice = player;
        BOARD_SIZE = 3;
    }

    @Override
    public String toString(){
        return "TICTACTOE";
    }
    @Override
    public void reset() {
        moves = 0;
        won = false;
        player2 = null;
        current = null;
    }

    @Override
    public void start() {
        boolean run = init();
        if (!run) {
            return;
        }
        printInstructions();
        System.out.println("\n");
        while( !won && moves < (BOARD_SIZE*BOARD_SIZE)){
            showBoard();
            boolean invalid;
            do {
                Field field = current.chooseMove();
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
        reset();
    }

    @Override
    public void printInstructions() {
        System.out.println("This this the classic game of tic tac toe we all love");
        System.out.println("In a 3x3 grid, each player chooses one field and puts their symbol inside");
        System.out.println("The one who first gets three in a row - horizontally, vertically or diagonally - wins");
        System.out.println("This is what the field looks like: ");
        int m = 1;
        for(int i = 0; i<BOARD_SIZE; i++){
            System.out.print("| ");
            for(int j = 0; j < BOARD_SIZE; j++){
                System.out.print( m + " | ");
                m++;
            }
            System.out.println();
        }
    }

    private boolean init(){
        board = new char[BOARD_SIZE][BOARD_SIZE];
        won = false;
        moves = 0;
        for (char[] chars : board) {
            Arrays.fill(chars, LEER);
        }
        player1 = new HumanPlayer('X', BOARD_SIZE, choice);
        Optional<Player> p2 = chooseOpp();
        if (p2.isEmpty()) {
            return false;
        } else{
            player2 = p2.get();
        }
        if (Math.random() < 0.5) {
            current = player1;
        } else{
            current = player2;
        }
        return true;
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


    private Optional<Player> chooseOpp(){
        System.out.println("Who do you want as an opponent?");
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer('O', BOARD_SIZE, choice));
        players.add(new ComputerPlayer('O'));
        return choice.choose(players);
    }

    private boolean makeMove(Field field, char symbol){
        if(isEmpty(field)){
            board[field.getRow()][field.getColumn()] = symbol;
            return false;
        } else{
            System.out.println("This field is not empty, please choose a different one");
            return true;
        }
    }

    private boolean isEmpty(Field field){
        return (board[field.getRow()][field.getColumn()] == LEER);
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

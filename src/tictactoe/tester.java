package tictactoe;

import ui.PlayerChoice;
import ui.PlayerInput;

public class tester {

    public static void main(String[] args) {
        PlayerChoice pc = new PlayerChoice(new PlayerInput());
        TicTacToe ticTacToe = new TicTacToe(pc);
        ticTacToe.start();
    }
}

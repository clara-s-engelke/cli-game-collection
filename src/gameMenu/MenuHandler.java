package gameMenu;

import game.Game;
import numberGuesser.NumberGuesser;
import tictactoe.TicTacToe;
import ui.PlayerChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuHandler {
	private final List<Game> games;
	private final PlayerChoice menu;
	
	
	public MenuHandler(PlayerChoice menu) {
		games = new ArrayList<>();
		games.add(new NumberGuesser(menu));
		games.add(new TicTacToe(menu));
		this.menu = menu;
	}
	
	public Optional<Game> showMainMenu() {
		return menu.choose(games);
	}
	
	 public boolean menuLoop() {
		Game game;
		Optional<Game> choice = showMainMenu();
		if (choice.isEmpty()) {
			return false;
		} else{
			game = choice.get();
			game.start();
			return true;
		}
		}
}

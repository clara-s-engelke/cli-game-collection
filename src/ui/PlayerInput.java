package ui;

import java.util.Scanner;

public class PlayerInput {
	Scanner s;
	
	public PlayerInput() {
		s = new Scanner(System.in);
	}
	
	public int readInt() {
		while (true) {
			try {
				return Integer.parseInt(s.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Error: Not a number!");
			}
		}
	}
	
//	public String readString() {
//		String string = null;
//		string = s.nextLine();
//		return string;
//	}
	
	public boolean inBounds(int min, int max, int num) {
        return num >= min && num < max;
	}
}

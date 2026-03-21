package ui;

import java.util.Scanner;

public class PlayerInput {
	Scanner s;
	
	public PlayerInput() {
		s = new Scanner(System.in);
	}
	
	public int readInt() {
		int num = -1;
		try {
			num = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Not a number!");
		}
		return num;
	}
	
//	public String readString() {
//		String string = null;
//		string = s.nextLine();
//		return string;
//	}
	
	public boolean inBounds(double min, double max, double num) {
        return num >= min && num < max;
	}
}

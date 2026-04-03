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

	public int readInBounds(int min, int max){
		while(true){
			int num = readInt()-1;
			if(inBounds(min, max, num)){
				return num;
			} else{
				System.out.println("not a number");
			}
		}
	}
	
	public char readLetter() {
		while(true){
			String str = s.nextLine().toLowerCase();
			char[] chars = str.toCharArray();
			if (chars.length == 1 && Character.isAlphabetic(chars[0])) {
				return chars[0];
			} else{
				System.out.println("Not a valid input! Please type just one letter!");
			}
		}
	}
	
	public boolean inBounds(int min, int max, int num) {
        return num >= min && num <= max;
	}
}

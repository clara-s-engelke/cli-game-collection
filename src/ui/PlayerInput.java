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
				System.out.println("not a nimber");
			}
		}
	}
	
//	public String readString() {
//		String string = null;
//		string = s.nextLine();
//		return string;
//	}
	
	public boolean inBounds(int min, int max, int num) {
        return num >= min && num <= max;
	}
}

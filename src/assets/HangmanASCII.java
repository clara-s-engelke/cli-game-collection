package assets;

import javax.swing.text.ChangedCharSetException;
import java.util.ArrayList;
import java.util.List;

public class HangmanASCII {
    static List<String> hangmanStates;

    public HangmanASCII() {
        hangmanStates = new ArrayList<>();
        hangmanStates.add("+---+\n|   |\n|\n|\n|  \n| \n| \n|\n======="); //0
        hangmanStates.add("+---+\n|   |\n|   0\n|\n|  \n| \n| \n|\n======="); //1
        hangmanStates.add("+---+\n|   |\n|   0\n|   |\n|  \n| \n| \n|\n======="); //2
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\n|  \n| \n| \n|\n======="); //3
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|  \n| \n| \n|\n======="); //4
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|   |\n| \n| \n|\n======="); //5
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|   |\n|  /\n| \n|\n======="); //6
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|   |\n|  / \\ \n| \n|\n======="); //7
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|   |\n|  / \\ \n| /   \n|\n======="); //8
        hangmanStates.add("+---+\n|   |\n|   0\n|  /|\\ \n|   |\n|  / \\ \n| /   \\ \n|\n======="); //9
    }

    public String getState(int index){
        return hangmanStates.get(index);
    }

}

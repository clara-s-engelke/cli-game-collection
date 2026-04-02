package hangman;

import java.io.*;
import java.util.*;

public class WordManager {
    private BufferedReader f;
    private Map<String, List<String>> categories;

    public WordManager(String file){
        InputStream in = getClass().getClassLoader().getResourceAsStream(file);
        f = new BufferedReader(new InputStreamReader(in));
    }

    public void initWordList(){
        List<String> lines = readList();
        categories = getCategories(lines);
    }

    public String chooseWord(){
       List<String> allWords = new ArrayList<>();

       for(List<String> words : categories.values()){
           allWords.addAll(words);
       }

       int index = (int) (Math.random()*(allWords.size())+1);
       return allWords.get(index);
    }


    private List<String> readList(){
        List<String> lines = new ArrayList<>();
        try {
            String line;
            line = f.readLine();
            while(line != null){
                lines.add(line);
                line = f.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error, the program will end now");
        }
        return lines;
    }

    private Map<String, List<String>> getCategories(List<String> lines){
        Map<String, List<String>> categories = new HashMap<>();

        for( String line : lines){
            String[] splitted = line.split(":", 2);
            if(splitted.length < 2){
                continue;
            }
            String category = splitted[0].trim();
            String[] allWords = splitted[1].split(",");
            List<String> words = new ArrayList<>();
            for(String word : allWords){
                word = word.trim();
                if(!word.isEmpty()){
                    words.add(word);
                }
            }
            if (words.isEmpty()) {
                continue;
            }
            categories.put(category, words);
        }

        return categories;
    }
}

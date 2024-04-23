

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WorldControler {


    public static int countWords(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int wordCount = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {

                if (!word.isEmpty()) {
                    wordCount++;
                }
            }
        }
        reader.close();
        return wordCount;
    }


    public static List<String> findLongestWord(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {

                if (!word.isEmpty() && word.length() >= maxLength) {
                    if (word.length() > maxLength) {
                        longestWords.clear(); // Очищаем список, если нашли более длинное слово
                        maxLength = word.length();
                    }
                    longestWords.add(word);
                }
            }
        }
        reader.close();


        Set<String> uniqueLongestWords = new HashSet<>(longestWords);
        longestWords.clear();
        longestWords.addAll(uniqueLongestWords);

        return longestWords;
    }


    public static Map<String, Integer> analyzeWordFrequency(String filename) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {

                word = word.toLowerCase();
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFrequency.entrySet());

        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        Map<String, Integer> sortedWordFrequency = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedWordFrequency.put(entry.getKey(), entry.getValue());
        }
        return sortedWordFrequency;
    }
}

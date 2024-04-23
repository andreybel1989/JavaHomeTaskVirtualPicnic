import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilename = "input.txt";

        try {

            int wordCount = WorldControler.countWords(inputFilename);
            System.out.println("Количество слов в файле: " + wordCount);


            System.out.println("Самые длинные слова в файле:");
            for (String word : WorldControler.findLongestWord(inputFilename)) {
                System.out.println(word);
            }


            Map<String, Integer> wordFrequency = WorldControler.analyzeWordFrequency(inputFilename);
            System.out.println("Частота каждого слова в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

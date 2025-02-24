import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BloomFilter bloomFilter1 = new BloomFilter();

        int numWords = 90000;
        Random random = new Random();
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < numWords; i++) {
            String randomWord = generateRandomWord(random, new Random().nextInt(10));
            bloomFilter1.insert(randomWord);
            words.add(randomWord);
        }

        int falsePositives = 0, truePositives = 0, notPresent = 0;


        for (int i = 0; i < numWords; i++) {
            String randomWord = generateRandomWord(random, new Random().nextInt(10));
            boolean result = bloomFilter1.lookup(randomWord);
            if (words.contains(randomWord)) {
                if (result) {
                    truePositives++;
                }
            } else {
                if (result) {
                    falsePositives++;
                } else {
                    notPresent++;
                }
            }
        }

        System.out.println("False Positives: " + falsePositives);
        System.out.println("True Positives: " + truePositives);
        System.out.println("Not Present: " + notPresent);
    }

    public static String generateRandomWord(Random random, int length) {
        StringBuilder word = new StringBuilder(length);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            word.append(randomChar);
        }
        return word.toString();
    }
}
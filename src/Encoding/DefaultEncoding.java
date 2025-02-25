package Encoding;

import java.util.ArrayList;
import java.util.List;

public class DefaultEncoding implements EncodingStrategy {
    @Override
    public List<Integer> encode(String message, int listLen) {

        List<Integer> indexes = new ArrayList<>();

        int[] hashSeeds = {3, 5, 7, 9, 11, 13};

        for (int seed : hashSeeds) {
            int hashValue = generateHash(message, seed);
            int index = Math.abs(hashValue % listLen);
            indexes.add(index);
        }

        return indexes;
    }

    private int generateHash(String message, int seed) {
        int hash = seed;
        for (int i = 0; i < message.length(); i++) {
            hash = hash * 137 + message.charAt(i);
        }
        return hash;
    }
}

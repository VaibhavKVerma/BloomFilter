package Encoding;

import java.util.BitSet;

public class DefaultEncoding implements EncodingStrategy {
    @Override
    public BitSet encode(String message, int listLen) {

        BitSet bitArray = new BitSet(listLen);

        int[] hashSeeds = {3, 5, 7, 9, 11, 13};

        for (int seed : hashSeeds) {
            int hashValue = generateHash(message, seed);
            int index = Math.abs(hashValue % listLen);
            bitArray.set(index, true);
        }

        return bitArray;
    }

    private int generateHash(String message, int seed) {
        int hash = seed;
        for (int i = 0; i < message.length(); i++) {
            hash = hash * 31 + message.charAt(i);
        }
        return hash;
    }
}

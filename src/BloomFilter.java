import Encoding.DefaultEncoding;
import Encoding.EncodingStrategy;

import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    private final BitSet bitSet;
    private final int listLen;
    private EncodingStrategy strategy;

    public BloomFilter(int listLen) {
        this.listLen = listLen;
        bitSet = new BitSet(listLen);
    }

    public BloomFilter(int listLen, EncodingStrategy strategy) {
        this(listLen);
        this.strategy = strategy;
    }

    public BloomFilter() {
        this(1000000);
        this.strategy = new DefaultEncoding();
    }

    public void insert(String message) {
        if(strategy == null) {
            throw new RuntimeException("Strategy not set");
        }
        List<Integer> messageBits = strategy.encode(message, listLen);
        for(int bit : messageBits) {
            bitSet.set(bit, true);
        }
    }

    public boolean lookup(String message) {
        if(strategy == null) {
            throw new RuntimeException("Strategy not set");
        }
        List<Integer> messageBits = strategy.encode(message, listLen);
        for(int bit : messageBits) {
            if(!bitSet.get(bit)) {
                return false;
            }
        }
        return true;
    }
}

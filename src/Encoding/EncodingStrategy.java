package Encoding;

import java.util.BitSet;
import java.util.List;

public interface EncodingStrategy {
    List<Integer> encode(String message, int listLen);
}

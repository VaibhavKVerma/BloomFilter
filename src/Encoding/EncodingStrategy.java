package Encoding;

import java.util.BitSet;
import java.util.List;

public interface EncodingStrategy {
    BitSet encode(String message, int listLen);
}

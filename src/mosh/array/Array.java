package mosh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Array {
    private int[] internal;

    public Array(int size) {
        internal = new int[]{size};
    }

    public Integer[] intersect(int[] inputArray) {
        Integer[] retVal = new Integer[]{internal.length};
        for (int i = 0; i < internal.length; i++) {
            for (int i1 = 0; i1 < inputArray.length; i1++)
                if (internal[i] == inputArray[i1])
                    retVal[i] = internal[i];
        }
        return Stream.of(retVal).distinct().toArray(Integer[]::new);
    }

}

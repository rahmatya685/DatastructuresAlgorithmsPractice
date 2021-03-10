package hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Arrays_DS {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int[] reversed = new int[a.length];
        int middle = a.length / 2;
        for (int i = 0; i < middle; i++) {
            int tail = (a.length - 1) - i;
            reversed[tail] = a[i];
            reversed[i] = a[tail];
        }
        if (a.length % 2 != 0)
            reversed[middle] = a[middle];
        return reversed;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 4, 2, 24, 4})));
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 4, 2, 4})));

    }
}


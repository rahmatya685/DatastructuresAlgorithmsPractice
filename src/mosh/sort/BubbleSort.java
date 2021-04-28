package mosh.sort;

import java.util.Arrays;

public class BubbleSort {

    void sort(int[] array) {
        boolean isAlreadySorted=true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    var temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isAlreadySorted = false;
                }
            }
            if (isAlreadySorted)
                break;
        }
        System.out.println(Arrays.toString(array));
    }
}

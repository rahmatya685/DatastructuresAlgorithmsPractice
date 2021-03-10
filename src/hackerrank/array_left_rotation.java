package hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class array_left_rotation {

    public static void main(String[] args) throws IOException {
        var result = rotateLeft2(4, List.of(1, 2, 3, 4, 5));
        System.out.println(result);
    }
    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        Integer[] array = new Integer[arr.size()];
        arr.toArray(array);

        for (int i = 0; i < d; i++) {
            int first =array[0];
            for (int j = 0; j < arr.size(); j++) {
                array[j] = array[ j + 1];
            }
            array[array.length-1]=first;
        }

        return Arrays.asList(array);
    }

    public static List<Integer> rotateLeft2(int d, List<Integer> list) {
        // Write your code here
        Integer[] array = new Integer[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int idx =i+d;
            if(idx>list.size()-1)
                idx=idx- list.size();
            array[i]=list.get(idx);
        }
        return Arrays.asList(array);
    }
}

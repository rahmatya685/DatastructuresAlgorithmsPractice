package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dynamic_array {

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();

        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));

        dynamicArray(2, queries);
    }

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        List<Integer> result = new ArrayList<>();

        int lastAnswer = 0;

        for (List<Integer> query : queries) {
            int x = query.get(1);
            int y = query.get(2);
            int idx = (x ^ lastAnswer) % n;
            List<Integer> currentList = arr.get(idx);
            int f = query.get(0);
            if (f == 1) {
                currentList.add(y);
            }
            if (f == 2) {
                int i = y % currentList.size();
                lastAnswer = currentList.get(i);
                result.add(lastAnswer);
                System.out.println(lastAnswer);
            }
        }

        return result;
    }
}

package JavaBrains;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static void main(String[] args) {

        int[] arra = new int[]{2, 3, 7, 4, 8};
        int[] resp = findSum(arra, 7);
        if (resp.length == 2  ) {
            System.out.printf(Arrays.toString(resp));
        } else {
            System.out.println("Failure");
        }

    }

    /**
     * Find the indices of two items in array which their sum would be equal to the target
     *
     * @param array input array to find the indices of items
     * @param target value which we should find two items which is equal to their sum
     * @return array of indices if found, otherwise empty array
     */
    public static int[] findSum(int[] array, int target) {
        Map<Integer, Integer> visit = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int delta = target - array[i] ;
            if (visit.containsKey(delta)) {
                return new int[]{visit.get(delta), i};
            }
            visit.put(array[i],i);
        }
        return new int[]{};
    }


}

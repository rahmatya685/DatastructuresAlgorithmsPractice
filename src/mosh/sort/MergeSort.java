package mosh.sort;


public class MergeSort {
    void sort(int[] array) {
        if (array.length < 2)
            return;

        var middle = array.length / 2;
        var leftPart = new int[middle];
        for (int i = 0; i < middle; i++) {
            leftPart[i] = array[i];
        }

        var rightPart = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            rightPart[i - middle] = array[i];

        sort(leftPart);
        sort(rightPart);

        merge(leftPart, rightPart, array);

    }

    private void merge(int[] leftPart, int[] rightPart, int[] array) {
        int i = 0, j = 0, k = 0;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j])
                array[k++] = leftPart[i++];
            else
                array[k++] = rightPart[j++];
        }
        while (i < leftPart.length)
            array[k++] = leftPart[i++];
        while (j < rightPart.length)
            array[k++] = rightPart[j++];
    }

}

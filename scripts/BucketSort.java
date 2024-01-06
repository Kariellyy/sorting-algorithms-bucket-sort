package scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static int[] bucketSort(int[] dataSet) {
        int maxVal = findMax(dataSet);
        int bucketSize = (int) Math.ceil((double) maxVal / dataSet.length);

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < dataSet.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : dataSet) {
            int bucketIndex = (int) Math.floor((double) value / bucketSize);
            buckets.get(bucketIndex).add(value);
        }

        for (List<Integer> bucket : buckets) {
            // Aplicar algum algoritmo de ordenação nos baldes
            Collections.sort(bucket);
        }

        // Concatenar os baldes ordenados
        List<Integer> sortedList = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            sortedList.addAll(bucket);
        }

        // Converter para array
        int[] sortedDataSet = sortedList.stream().mapToInt(Integer::intValue).toArray();

        return sortedDataSet;
    }

    private static int findMax(int[] dataSet) {
        int max = Integer.MIN_VALUE;
        for (int value : dataSet) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}

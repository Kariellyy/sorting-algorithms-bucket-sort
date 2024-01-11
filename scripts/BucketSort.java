package scripts;

import java.util.ArrayList;

public class BucketSort {
    private SortingAlgorithm innerAlgorithm;

    public BucketSort(SortingAlgorithm innerAlgorithm) {
        this.innerAlgorithm = innerAlgorithm;
    }

    public int[] sort(int[] dataSet) {
        // Encontre o valor máximo e mínimo no conjunto de dados
        int maxVal = dataSet[0];
        int minVal = dataSet[0];

        for (int value : dataSet) {
            if (value > maxVal) {
                maxVal = value;
            }
            if (value < minVal) {
                minVal = value;
            }
        }

        // Use a heurística para determinar o número de baldes
        int numBuckets = (int) Math.ceil(Math.sqrt(dataSet.length));
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribua os elementos nos baldes
        for (int value : dataSet) {
            int bucketIndex = (int) ((double) (value - minVal) / (maxVal - minVal + 1) * numBuckets);
            buckets.get(bucketIndex).add(value);
        }

        // Use o algoritmo interno para ordenar cada balde
        for (ArrayList<Integer> bucket : buckets) {
            int[] bucketArray = bucket.stream().mapToInt(Integer::intValue).toArray();
            innerAlgorithm.sort(bucketArray);
            for (int i = 0; i < bucketArray.length; i++) {
                dataSet[i] = bucketArray[i];
            }
        }

        return dataSet;
    }
}

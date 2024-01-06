package scripts;


public class BubbleSort implements SortingAlgorithmsBucketSort {
    @Override
    public int[] sort(int[] dataSet) {
        // Utilizar o Bucket Sort para pré-processamento
        int[] preProcessedData = BucketSort.bucketSort(dataSet);

        // Aplicar Bubble Sort nos dados pré-processados
        int[] sortedDataSet = bubbleSort(preProcessedData);

        return sortedDataSet;
    }

    private int[] bubbleSort(int[] dataSet) {
        for (int i = 0; i < dataSet.length - 1; i++) {
            for (int j = 0; j < dataSet.length - 1 - i; j++) {
                if (dataSet[j] > dataSet[j + 1]) {
                    int temp = dataSet[j];
                    dataSet[j] = dataSet[j + 1];
                    dataSet[j + 1] = temp;
                }
            }
        }
        return dataSet;
    }
}

package java2.algos2;
import java.util.ArrayList;
import java.util.List;

/*
Значения распределены +- равномерно по условию, укладываются в [0, 1)

Лучше всего здесь подойдёт BucketSort
Сложность: O(n), где n - количество элементов в массиве
*/


public class BucketSort1 {

    public static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            double key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(double[] arr) {
        int n = arr.length;
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (double value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        double[] arr1 = {0.42, 0.11, 0.87, 0.35};
        double[] arr2 = {0.01, 0.99, 0.50};
        bucketSort(arr1);
        bucketSort(arr2);

        System.out.println("Sorted array is:");
        for (double num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (double num : arr2) {
            System.out.print(num + " ");
        }
    }
}

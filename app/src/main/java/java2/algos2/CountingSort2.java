package java2.algos2;
/*
В журнале нужно упорядочить оценки студентов. Каждая оценка — целое число от 0 до 100, а студентов может быть до 500 000. Требуется использовать свойства небольшого диапазона оценок.

Студентов >> оценок => классический пример сортировки подсчётом
Сложность: O(n), где n - количество студентов
*/
public class CountingSort2 {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int[] count = new int[101];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= 100; i++) {
            while (count[i] > 0) {
                output[index++] = i;
                count[i]--;
            }
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 4, 1, 0};
        int[] arr2 = {100, 0, 50, 50};
        countingSort(arr1);
        countingSort(arr2);

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

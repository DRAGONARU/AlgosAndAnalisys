package java2.algos2;
import java.util.Arrays;
/*
Серийные номера состоят только из цифр и имеют одинаковую длину. Для сортировки разрешено обрабатывать по одной позиции номера за проход.

O(n)
*/
public class RadixSort3 {
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
        
    }

    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };

        radixSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

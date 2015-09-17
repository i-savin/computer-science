package isavin.tasks.arrays;

import java.util.Formatter;

public class SpiralArray {

    public static void main(String[] args) {
        int size = 1143;
        int[][] arr = centerArray(size);
        // for (int i = 0; i < size; i++) {
        //     for (int j = 0; j < size; j++) {
        //         Formatter formatter = new Formatter();
        //         System.out.print(formatter.format("%2d ", arr[i][j]));
        //         // System.out.print(arr[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        int sum = 0;
        for (int i = 0, j = 0; i < size; i++, j++) {
            sum += arr[i][j];
        }
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            sum += arr[i][j];
        }
        sum -= 1;
        System.out.println(sum);
    }

    public static int[][] centerArray(int size) {
        int[][] result = new int[size][size];
        int counter = 1;
        int i = size / 2;
        int j = size / 2;
        int step = 1;
        result[i][j] = counter++;
        while (step < size) {
            for (int x = 0; x < step; x++) {
                j++;
                result[i][j] = counter++;
            }
            for (int y = 0; y < step; y++) {
                i++;
                result[i][j] = counter++;
            }
            step++;
            for (int x = step; x > 0; x--) {
                j--;
                result[i][j] = counter++;
            }
            for (int y = step; y > 0; y--) {
                i--;
                result[i][j] = counter++;
            }
            step++;
        }
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        while (++j < size) {
            // j++;
            result[i][j] = counter++;
        }
        return result;
    }
}

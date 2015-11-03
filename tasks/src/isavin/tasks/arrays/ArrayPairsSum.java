package isavin.tasks.arrays;

import java.util.Map;
import java.util.HashMap;

public class ArrayPairsSum {
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 5, 6, 7, 0};
		int n = 7;
		System.out.print("Array:");
		for (int a : array) {
			System.out.print(" " + a);
		}
		System.out.println();
		//findPairsSum(array, n);
		System.out.println("Missing number is: " + findMissing(array, n));
	}
	
	/**
	 * Given an array A = [3,7,2,5,6,4] for a number N.
	 * Print the pairs from that array A that sums up to N. You should print each pair once.
	 */
	public static void findPairsSum(int[] array, int sum) {
		System.out.println("Finding pairs in array that sum is " + sum);
		Map<Integer, Boolean> map = new HashMap<>();
		for (int a : array) {
			map.put(a, new Boolean(true));
		}
		
		for (Integer i : map.keySet()) {
			if (map.get(sum - i) != null) {
				System.out.println(i + " : " + (sum - i));
				map.put(i, null);
			}
		}
	}

	/**
	 * Given an array A [0, 1, 3, 4,9,5,7,6] and number N.
     * This means that the array consists of the numbers from 0 ... N. However, as you see, 8 is missing in A. Print the missing number.
     * Think about the case N = 10^6
	 */
	public static int findMissing(int[] array, int n) {
		int result = n;
		
		for (int i = 0; i < array.length; i++) {
			result ^= i ^ array[i];
		}
		
		return result;
	}
}

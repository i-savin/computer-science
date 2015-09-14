package isavin.tasks.backtracking;

/**
 * Fill two instances of all numbers from 1 to n in a specific way
 * Given a number n, create an array of size 2n such that the array contains 
 * 2 instances of every number from 1 to n, 
 * and the number of elements between two instances of a number i is equal to i. 
 * If such a configuration is not possible, then print the same.
 * http://www.geeksforgeeks.org/fill-two-instances-numbers-1-n-specific-way/
 */
public class FillTwoInstances {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Empty parameters list");
			System.out.println("Usage: java isavin.tasks.backtracking.FillTwoInstances number");
			System.exit(-1);
		}
		int n = Integer.parseInt(args[0]);
		int[] array = new int[n * 2];
		if (fill(array, n)) {
			for (int i : array) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			System.out.println("Impossible");
		}
	}

	public static boolean fill(int[] array, int number) {
		if (number == 0) {
			return true;
		}
		int i = 0;
		while (i + number + 1 < array.length) {
			if (array[i] == 0 && array[i + number + 1] == 0) {
				array[i] = number;
				array[i + number + 1] = number;
				if (fill(array, number - 1)) {
					return true;
				} else {
					array[i] = 0;
					array[i + number + 1] = 0;
				}
			}
			i++;
		}
		return false;
	}
}

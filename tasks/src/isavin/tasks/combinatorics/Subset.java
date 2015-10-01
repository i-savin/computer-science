package isavin.tasks.combinatorics;

public class Subset {
	
	
	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		printSubsets(array, n, k);
		//printSubsetsReverse(array, n, k);
	}
	
	private static void printSubsets(int[] array, int n, int k) {
		int[] bits = new int[n];
		for (int i = n - k; i < n; i++) {
			bits[i] = 1;
		}
		//Sequence.print(array);
		Sequence.print(bits);
		//printArrayByMask(array, bits);
		while (next(bits)) {
			Sequence.print(bits);
			//printArrayByMask(array, bits);
		}
	}

	private static boolean next(int[] array) {
		int s = array.length - 2;
		while (s >= 0 && !(array[s] == 0 && array[s+1] == 1)) {
			s--;
		}
		if (s < 0) {
			return false;
		}
		int num = 0;
		for (int k = s; k < array.length; k++) {
			num += array[k];
		}
		array[s] = 1;
		for (int k = s + 1; k < array.length - num + 1; k++) {
			array[k] = 0;
		}
		for (int k = array.length - num + 1; k < array.length; k++) {
			array[k] = 1;
		}
		return true;
	}
	
	private static void printSubsetsReverse(int[] array, int n, int k) {
		int[] bits = new int[n];
		for (int i = 0; i < k; i++) {
			bits[i] = 1;
		}
		//Sequence.print(array);
		Sequence.print(bits);
		//printArrayByMask(array, bits);
		while (previous(bits)) {
			Sequence.print(bits);
			//printArrayByMask(array, bits);
		}
	}
	
	private static boolean previous(int[] mask) {
		//ищем первый справа элемент, равный 0, такой чтобы предыдущий был равен 1
		int s = mask.length - 1;
		while (s > 0 && !(mask[s] == 0 && mask[s-1] == 1)) {
			s--;
		}
		//System.out.println(s);
		if (s == 0) {
			return false;
		}
		//s - индекс элемента, который нужно заменить на 1, тогда предыдущий нужно заменить на 0
		int num = 0; //число единиц на участке [0 - s)
		for (int i = 0; i < s - 1; i++) {
			num += mask[i];
		}
		//System.out.println(num);
		mask[s] = 1;
		for (int i = 0; i < num; i++) {
			mask[i] = 1;
		}
		for (int i = num; i < s; i++) {
			mask[i] = 0;
		}
		return true;
	}
	
	private static void printArrayByMask(int[] array, int[] mask) {
		if (array.length != mask.length) {
			throw new IllegalArgumentException("Array length and mask length are not equal");
		}
		
		for (int i = 0; i < array.length; i++) {
			if (mask[i] == 1) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
		
	}
}

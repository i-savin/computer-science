package isavin;

public class MergeSort {
	
	public static void sort(int[] a) {
		Main.comparing = 0;
		Main.swaping = 0;
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			sort(a, start, middle);
			sort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
	}
	
	private static void merge(int[] a, int start, int middle, int end) {
		int[] left = new int[middle - start + 1];
		int[] right = new int[end - middle];
		
		for (int i = 0; i < left.length; i++) {
			left[i] = a[start + i];
		}
		
		for (int i = 0; i < right.length; i++) {
			right[i] = a[middle + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int index = start;
		
		while (i < left.length && j < right.length) {
			Main.comparing++;
			if (left[i] <= right[j]) {
				Main.swaping++;
				a[index] = left[i];
				index++;
				i++;
			} else {
				Main.swaping++;
				a[index] = right[j];
				index++;
				j++;
			}
		}
		
		while (i < left.length) {
			Main.swaping++;
			a[index] = left[i];
			index++;
			i++;
		}
		
		while (j < right.length) {
			Main.swaping++;
			a[index] = right[j];
			index++;
			j++;
		}
	}

}

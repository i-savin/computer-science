package isavin;

public class BubbleSort {
	
	public static void sort(int[] a, boolean desc) {
		Main.comparing = 0;
		Main.swaping = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (!desc) {
					Main.comparing++;
					if (a[j] > a[j + 1]) {
						swap(a, j, j + 1);
					}
				} else {
					Main.comparing++;
					if (a[j] < a[j + 1]) {
						swap(a, j, j + 1);
					}
				}
			}
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		Main.swaping++;
		int b = a[i];
		a[i] = a[j];
		a[j] = b;
	}

}

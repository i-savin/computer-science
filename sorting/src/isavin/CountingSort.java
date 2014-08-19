package isavin;

public class CountingSort {
	
	public static int[] sort(int[] a, int max) {
		int[] c = new int[max];
		int[] b = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}
		
		for (int i = 1; i < max; i++) {
			c[i] += c[i-1];
		}
		
		for (int i = b.length - 1; i >=0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
		
		return b;
	}

}

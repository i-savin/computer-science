package isavin;

public class Main {

	private static final int ARRAY_CAPACITY = 1000000;
	private static final int MAX_VALUE_FACTOR = 10;
	
	public static long comparing;
	public static long swaping;

	public static void main(String[] args) {
		int[] a = generateArray(ARRAY_CAPACITY);
		long startTime = System.currentTimeMillis();
//		printArray(a);
//		BubbleSort.sort(a, false);
//		printArray(a);
//		System.out.println("Comparing: " + Main.comparing);
//		System.out.println("Swaping: " + Main.swaping);
//		QuickSort.sort(a);
//		MergeSort.sort(a);
		InsertionSort.sort(a, 0, a.length - 1);
//		HeapSort.sort(a);
//		printArray(a);
//		CountingSort.sort(a, ARRAY_CAPACITY * MAX_VALUE_FACTOR);
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime));
		System.out.println("Comparing: " + Main.comparing);
		System.out.println("Swaping: " + Main.swaping);

//		BubbleSort.sort(a, false);
//		printArray(a);
//		System.out.println("Comparing: " + BubbleSort.comparing);
//		System.out.println("Swaping: " + BubbleSort.swaping);
//		
//		BubbleSort.sort(a, false);
//		printArray(a);
//		System.out.println("Comparing: " + BubbleSort.comparing);
//		System.out.println("Swaping: " + BubbleSort.swaping);
		
	}

	private static int[] generateArray(int capacity) {
		int[] result = new int[capacity];
		
		for (int i = 0; i < capacity; i++) {
			result[i] = (int) Math.round(Math.random() * capacity * MAX_VALUE_FACTOR);
		}
		
		return result;
	}
	
	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
	
}

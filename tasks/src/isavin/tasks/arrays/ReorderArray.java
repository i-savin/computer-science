package isavin.tasks.arrays;

import java.util.Map;
import java.util.HashMap;

/**
 * We have an array of objects A and an array of indexes B. 
 * Reorder objects in array A with given indexes in array B. Do not change array A's length.
 * Example:
 * {C, D, E, F, G}
 * {4, 3, 1, 0, 2}
 * {F, E, G, D, C}
 */
public class ReorderArray {
	
	public static void main(String[] args) {
		char[] a = new char[] {'C', 'D', 'E', 'F', 'G'};
		int[] b = new int[] {4, 3, 1, 0, 2};
		int n = 7;
		System.out.println("Array: " + new String(a));
		a = reorderArray2(a, b);
		System.out.println("Reordered Array: " + new String(a));
	}

	public static char[] reorderArray(char[] charArray, int[] indexes) {
		if (charArray.length != indexes.length) {
			throw new IllegalArgumentException("Character array and indexes array sizes are not equal!");
		}
		Map<Integer, Character> indexMap = new HashMap<>();
		for (int i = 0; i < indexes.length; i++) {
			indexMap.put(indexes[i], charArray[i]);
		}
		
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = indexMap.get(i).charValue();
		}
		return charArray;
	}
	
	public static char[] reorderArray2(char[] charArray, int[] indexes) {
		if (charArray.length != indexes.length) {
			throw new IllegalArgumentException("Character array and indexes array sizes are not equal!");
		}
		
		for (int i = 0; i < indexes.length; i++) {
			while (indexes[i] != i) {
				swap(charArray, i, indexes[i]);
				swap(indexes, i, indexes[i]);
			}
		}
		
		return charArray;
	}
	
	public static void swap(char [] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void swap(int [] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

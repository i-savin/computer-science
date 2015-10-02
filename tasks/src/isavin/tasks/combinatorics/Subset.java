package isavin.tasks.combinatorics;

public class Subset {
	
	
	public static void main(String[] args) {
		int n = 20;
		int k = 3;
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		//printSubsets(array, n, k);
		printSubsetsReverse(array, n, k);
	}
	
	/**
	 * Печатает перестановки в прямом порядке
	 */
	private static void printSubsets(int[] array, int n, int k) {
		int[] bits = new int[n];
		for (int i = n - k; i < n; i++) {
			bits[i] = 1;
		}
		Sequence.print(array);
		//Sequence.print(bits);
		printArrayByMask(array, bits);
		while (next(bits)) {
			//Sequence.print(bits);
			printArrayByMask(array, bits);
		}
	}

	/**
	 * Метод для поиска лексикографически следующей перестановки:
	 * 00011 -> 00101 -> 00110 -> 01001 -> 01010 -> 01100 -> ... -> 11000
	 * Возвращает true, если лексикографически следующая последовательность существует
	 * и false - если текущая последовательность лексикографически последняя
	 */
	private static boolean next(int[] array) {
		int s = array.length - 2;
		//ищем первый элемент равный 0 такой чтобы следующий был равен 1
		while (s >= 0 && !(array[s] == 0 && array[s+1] == 1)) {
			s--;
		}
		if (s < 0) {
			return false;
		}
		//s - индекс элемента, который нужно заменить на 1
		//тогда для сохранения числа единиц нужно заменить один из 
		//элементов справа от s на 0
		//чтообы последовательность была лексикографически следующей,
		//нужно после s сначала расположить все 0, которые были на участке [s, n)
		//затем все 1, которые были на этом участке
		int num = 0;
		//считаем количество единиц на участке [s, n)
		for (int k = s; k < array.length; k++) {
			num += array[k];
		}
		array[s] = 1;
		// (n - s - num) - количество нулей на участке на участке [s, n)
		//тогда (s + (n - s - num)) = (n - num) - индекс последнего элемента, который
		//в новой перестановке должен быть равен 1
		for (int k = s + 1; k < array.length - num + 1; k++) {
			array[k] = 0;
		}
		for (int k = array.length - num + 1; k < array.length; k++) {
			array[k] = 1;
		}
		return true;
	}
	
	/**
	 * Печатает перестановки в обратном порядке
	 */
	private static void printSubsetsReverse(int[] array, int n, int k) {
		int[] bits = new int[n];
		for (int i = 0; i < k; i++) {
			bits[i] = 1;
		}
		Sequence.print(array);
		//Sequence.print(bits);
		printArrayByMask(array, bits);
		while (previous(bits)) {
			//Sequence.print(bits);
			printArrayByMask(array, bits);
		}
	}
	
	/**
	 * Метод для поиска лексикографически предыдущей перестановки:
	 * 11000 -> 10100 -> 10010 -> 10001 -> 01100 -> ... -> 00011
	 * Возвращает true, если лексикографически предыдущая последовательность существует
	 * и false - если текущая последовательность лексикографически первая
	 */
	private static boolean previous(int[] mask) {
		//ищем первый справа элемент, равный 1, такой чтобы следующий был равен 0
		int s = mask.length - 2;
		while (s >= 0 && !(mask[s] == 1 && mask[s+1] == 0)) {
			s--;
		}

		if (s < 0) {//1
			return false;
		}
		//s - индекс элемента, который нужно заменить на 0
		//чтобы это сделать корректно, нужно один элемент справа от s заменить на 1
		//чтобы полученная перестановка была лексикографически предыдущей,
		//нужно после s сначала расположить все 1, затем оставшиеся 0:
		int num = 0; //число единиц на участке [s - n)
		for (int i = s; i < mask.length; i++) {
			num += mask[i];//1
		}
		//System.out.println(num);
		mask[s] = 0;
		//записываем в массив выисленное число единиц
		for (int i = s + 1; i < s + num + 1; i++) {
			mask[i] = 1;
		}
		//оставшийся массив до конца заполняем 0
		for (int i = s + num + 1; i < mask.length; i++) {
			mask[i] = 0;
		}
		return true;
	}
	
	/**
	 * Печатает массив по маске
	 */
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

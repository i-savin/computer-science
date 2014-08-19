package isavin;

import java.util.Random;
/**
 * Быстрая сортировка
 * Реализация: сначала выбирается опорный элемент,
 * затем массив упорядочивается так, чтобы в его левой части
 * оказались числа меньшие или равные опорному элементу.
 * Процедура повторяется рекурсивно для левой
 * и правой части массива.
 * В качестве опорного элемента можно выбрать
 * какой-то фиксированный элемент (например, первый или 
 * последний), случайный элемент или медиану из
 * трех элементов. Медиана - не среднее арифметическое,
 * а средний по величине элемент из трех.
 * 
 * Время работы: лучший случай - nlog(n), худший случай - n^2
 * Лучше всего работает со случайным выбором опорного
 * элемента и со случайныым выбором медианы. Сложность
 * в среднем случаее интуитивно также nlog(n)
 *  
 * 
 * @author isavin
 *
 */
public class QuickSort {

	public static void sort(int[] a) {
		Main.comparing = 0;
		Main.swaping = 0;
//		quicksortWithMedian(a, 0, a.length - 1, false);
		quicksort(a, 0, a.length - 1, true);
	}
	
	/**
	 * Метод, который осуществляет сортировку массива.
	 * В этом методе опорный элемент выбирается
	 * или случайно, или как первый элемент массива.
	 * 
	 * @param array сортируемый массив
	 * @param start индекс первого элемента
	 * @param end индекс последнего элемента
	 * @param isRandom true, опорный элемент
	 * 			нужно выбирать случайным образом
	 */
	private static void quicksort(int[] array, int start, int end, boolean isRandom) {
		if ( start >= end ) {
			return;
		}
		
		if (end - start <= 20) {
			InsertionSort.sort(array, start, end);
			return;
		}
		
		int pivot = partition(array, start, end, isRandom);
		quicksort(array, start, pivot - 1, isRandom);
		quicksort(array, pivot + 1, end, isRandom);
	}
	
	/**
	 * Сортировка массива с выбором опорного
	 * элемента через медиану трех - или трех
	 * случайных, или первого, среднего и последнего 
	 * элементов массива.
	 * 
	 * @param array сортируемый массив
	 * @param start индекс первого элемента
	 * @param end индекс последнего элемента
	 * @param isRandom true, если медиану нужно
	 * 			выбирать из трех случайных элементов
	 */
	private static void quicksortWithMedian(int[] array, int start, int end, boolean isRandom) {
		if ( start >= end ) {
			return;
		}
		
		int pivot = partitionMedian(array, start, end, isRandom);
		
		quicksort(array, start, pivot, isRandom);
		quicksort(array, pivot + 1, end, isRandom);
	}
	
	/**
	 * Разбиение массива относительно опорного элемента -
	 * слева меньше опорного элемента,
	 * справа больше или равный опорному элементу.
	 * В этом методе возможные выборы опорного элемента - 
	 * первый, последний или случайный элемент заданного массива.
	 * 
	 * Опорный элемент размещается в конце массива. 
	 * На первой итерации индекс, который нужно вернуть из метода,
	 * указывает на первый элемент. Далее осуществляется проход по
	 * массиву. Как только встречается элемент меньший или равный
	 * опорнуму, он меняется местами с элементом, на который
	 * указывает индекс, а сам индекс увеличивается. Таким образом,
	 * опорный элемент встретится на последней итерации,
	 * произойдет обмен и индекс будет указывать на опорный
	 * элемент. Этот индекс будет у опорного элемента и в уже
	 * отсортированном массиве, так что в следующие
	 * вызовах этого метода нужно передавать все элементы,
	 * кроме самого опорного.
	 * 
	 * @param a сортируемый массив
	 * @param start первый элемент участка массива
	 * @param end последний элемент участка массива
	 * @param isRandom true, если опорный элемент нужно 
	 * 			выбирать случайным образом
	 * 			false, чтобы опорным был первый элемент
	 * @return индекс опорного элемента
	 */
	private static int partition (int[] a, int start, int end, boolean isRandom) {
		Random random = new Random();
		/*
		 * если выбираем пивот случайным образом
		 * или берем первый элемент,
		 * то нужно поместить его в конец массива
		 */
		int iPivot; 
		if (isRandom) {
			iPivot = start + random.nextInt(end - start + 1);
		} else {
			iPivot = start;
		}
		int pivot = a[iPivot];
		swap(a, iPivot, end);
		
		int index = start;
		for (int i = start; i < end; i++ ) {
			Main.comparing++;
			if ( a[i] <= pivot ) {
				swap(a, i, index);
				index++;
			}
		}
		swap(a, index, end);
		return index;
	}
	
	/**
	 * Разбиение массива на два с помощью
	 * опорного элемента, найденного как медиана
	 * 
	 * Массив обходится с двух концов и каждый
	 * элемент сравнивается с опорным. Обход слева направа
	 * продолжается до тех пор, пока не встретится элемент
	 * больший или равный опорному (его индекс запоминается).
	 * Движение справа продолжается,
	 * пока не встретится элемент меньший или равный опорному
	 * (его индекс также запоминается).
	 * После этого, если индекс обхода с левого края меньше 
	 * индекса обхода с правого края, то меняются элементы с запомненными
	 * индексами и обход справ и слева продолжается, пока индекс
	 * слева не сравняется с индексом справа. Как только это 
	 * произойдет, индекс справа будет указывать на индекс разбиения.
	 * Этот индекс должен войти в следующий вызов только один раз,
	 * в разбиение слева:
	 * 
	 * @param a сортируемый массив
	 * @param start индекс первого элемента
	 * @param end индекс последнего элемента
	 * @param isRandom true, если медиану нужно
	 * 			выбирать из трех случайных элементов
	 * @return индекс опорного элемента
	 * 
	 * @see #quicksortWithMedian(int[], int, int, boolean)
	 * @see #getMegian(int[], int, int, boolean)
	 */
	private static int partitionMedian(int[] a, int start, int end, boolean isRandom) {
		int index = getMegian(a, start, end, isRandom);
		int pivot = a[index];
		swap(a, index, start);
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j) {
				Main.comparing++;
				if (a[i] >= pivot) {
					break;
				}
				i++;
			}
			while (j > i) {
				Main.comparing++;
				if (a[j] <= pivot) {
					break;
				}
				j--;
			}
			if (i < j) {
				swap(a, i, j);
			}
		}
		
		return j;
	}
	
	
	/**
	 * Возвращает индекс медианы трех элементов.
	 * Если isRandom == true, то элементы для определения
	 * медианы выбираются случайным образом. Иначе
	 * берутся первый, последний и средний элементы
	 * 
	 * @param a массив, из которого выбирается медиана
	 * @param start индекс первого элемента
	 * @param end индекс последнего элемента
	 * @param isRandom логический параметр, определяющий генерить
	 * 			ли три элемента случайным образом или выбрать
	 * 			первый, средний и последний элементы
	 * @return индекс медианы
	 */
	private static int getMegian(int[] a, int start, int end, boolean isRandom) {
		int firstElementIndex;
		int lastElementIndex;
		int midElementIndex;
		if (!isRandom) {
			firstElementIndex = start;
			lastElementIndex = end;
			midElementIndex = (start + end) / 2;
		} else {
			Random random = new Random();
			firstElementIndex = start + random.nextInt(end - start + 1);
			lastElementIndex = start + random.nextInt(end - start + 1);
			midElementIndex = start + random.nextInt(end - start + 1);
		}
		
		if (a[firstElementIndex] < a[lastElementIndex]) {
			if (a[firstElementIndex] > a[midElementIndex]) {
				return firstElementIndex;
			} else {
				if (a[midElementIndex] < a[lastElementIndex]) {
					return midElementIndex;
				} else {
					return lastElementIndex;
				}
			}
		} else {
			if (a[lastElementIndex] < a[midElementIndex]) {
				if (a[midElementIndex] < a[firstElementIndex]) {
					return midElementIndex;
				} else {
					return firstElementIndex;
				}
			} else {
				return lastElementIndex;
			}
		}
	}
	
	/**
	 * Перестановка элементов местами. Передаются
	 * массив, содержащий элементы, и индексы
	 * элементов, которые нужно поменять местами
	 * 
	 * @param a массив, содержищий элементы
	 * @param i индекс первого элемента
	 * @param j индекс второго элемента
	 */
	private static void swap(int[] a, int i, int j) {
		Main.swaping++;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

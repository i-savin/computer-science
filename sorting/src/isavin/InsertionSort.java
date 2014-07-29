package isavin;

/**
 * Сортировка вставками. Удобна для сортировка
 * небольших последовательностей.
 * Для понимания нужно представить, как 
 * сортируются карты в руке. Карта из левой части
 * находящихся в руке карт переносится на свое место
 * в правую часть относительно уже находящихся
 * в правой части. Так и тут - внешний цикл 
 * идет начиная со второго элемента до конца массива.
 * Внутренний цикл идет с первого элемента и до элемента
 * внешнего цикла, сравнивая текущий элемент внешнего цикла
 * с текущим элементов внутреннего: если элемент
 * внутреннего цикла больше текущего элемента внешнего,
 * элемент внутреннего цикла смещается на один вперед. Так
 * продолжается до тех пор, пока во внутреннем цикле
 * не наступит первый элемент или пока текущий элемент
 * внутреннего цикла не будет меньше текущего элемента внешнего.
 * Тогда текущий элемент внешнего цикла записывается на месту текущего
 * элемента внутреннего цикла и наступает следующая итерация внешнего
 * цикла. По сути дела во внутреннем цикле происходит
 * сдвиг влево всех элементов больших текущего, а затем
 * вставка его на освободившееся место.
 * 
 * Сложность в лучшем случае O(n).
 * Сложность в худшем случае O(n^2).
 * 
 * @author isavin
 *
 */
public class InsertionSort {
	
	public static void sort(int[] a) {
		Main.swaping = 0;
		Main.comparing = 0;
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			Main.comparing++;
			while (j >= 0 && a[j] >= key) {
				Main.swaping++;
				Main.comparing++;
				a[j+1] = a[j];
				j--;
			}
			Main.swaping++;
			a[j+1] = key;
		}
	}

}

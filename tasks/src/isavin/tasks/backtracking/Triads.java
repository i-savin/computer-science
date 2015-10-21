package isavin.tasks.backtracking;

import isavin.tasks.combinatorics.Sequence;

/**
 * Перечислить все последовательности из n единиц, нулей и двоек, в которых
 * никакая группа цифр не повторяется два раза (нет куска вида ХХ).
 *
 * Решаем обходом дерева. Например для n=2 дерево выглядит так:
 * 00 01 02 10 11 12 20 21 22
 *  \ | /    \ | /    \ | /
 *    0        1        2
 *     \_______|________|
 * Ненужные ветви отбрасываем
 */
public class Triads extends BacktrackingAbstract {

	private int n;
	private int[] source;
	private int currentSize;

	public static void main(String[] args) {
		int n = 4;
        System.out.println("n: " + n);

        Triads triads = new Triads(n);

        triads.proceed();
	}

	public Triads(int n) {
		this.n = n;
		this.source = new int[n];
		this.currentSize = 0;
	}

	@Override
	protected void upAndWork() {
		while(isUp()) {
            up();
        }
        work();
	}

	@Override
	protected void work() {
		if (currentSize <= 1 || currentSize == n && source[currentSize - 1] != source[currentSize - 2]) {
			Sequence.print(source);
			solutionsNumber++;
		}
	}

	@Override
	protected boolean isUp() {
		if (currentSize <= 1) {
			return true;
		}
		return (currentSize < n && source[currentSize - 1] != source[currentSize - 2]);
	}

	@Override
	protected boolean isRight() {
		return source[currentSize - 1] < 2;
	}

	@Override
	protected boolean isDown() {
		return currentSize > 0;
	}

	@Override
	protected void up() {
		currentSize++;
	}

	@Override
	protected void down() {
		source[currentSize - 1] = 0;
		currentSize--;
	}

	@Override
	protected void right() {
		source[currentSize - 1]++;
	}
}

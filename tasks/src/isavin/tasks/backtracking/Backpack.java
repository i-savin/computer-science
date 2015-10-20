package isavin.tasks.backtracking;

import isavin.tasks.combinatorics.Sequence;

/**
 * Дана массив из n чисел и число s. Требуется узнать, можно ли число s
 * представить как сумму некоторых числе массива.
 *
 * Решаем обходом дерева. k-я позиция дерева - последовательность из k
 * boolean значений, показывающих, входит ли член массива с таким индексом
 * в нужную сумму. Позиция допустима, если сумма не превосходит s.
 * Робот, осуществляющий обход дерева, может двигаться вверх, вправо (к брату) и
 * вниз. Пример дерева:
 * 11 10 01 00
 *  \ /   \ /
 *   1     0
 *    \___/
 */
public class Backpack extends BacktrackingAbstract {

    private int sum;
    private int[] source;
    private boolean[] mask;
    private int currentMaskSize;
    private int currentSum;

    public static void main(String[] args) {
        int n = 10;
        int s = 10;
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = i + 1;
        }

        System.out.print("Source array: ");
        Sequence.print(source);
        System.out.println("Target sum: " + s);

        Backpack backpack = new Backpack(source, s);

        backpack.proceed();
    }

    public Backpack(int[] source, int sum) {
        this.source = source;
        this.sum = sum;
        this.mask = new boolean[source.length];
        this.currentMaskSize = 0;
        this.solutionsNumber = 0;
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
        if (currentSum == sum) {
            solutionsNumber++;
            printArrayByMask();
        }
    }

	@Override
    protected boolean isUp() {
        return (currentMaskSize < source.length) && (currentSum < sum);
    }

	@Override
    protected void up() {
        currentMaskSize++;
        currentSum += source[currentMaskSize-1];
        mask[currentMaskSize-1] = true;
    }

	@Override
    protected boolean isRight() {
        return mask[currentMaskSize-1];
    }

	@Override
    protected void right() {
        currentSum -= source[currentMaskSize-1];
        mask[currentMaskSize-1] = false;
    }

	@Override
    protected boolean isDown() {
        return currentMaskSize > 0;
    }

	@Override
    protected void down() {
        if (isRight()) {
            currentSum -= source[currentMaskSize-1];
        }
        currentMaskSize--;
    }

    private void printArrayByMask() {
        for (int i = 0; i < currentMaskSize; i++) {
            if (mask[i]) {
                System.out.print(source[i] + " ");
            }
        }
        System.out.println();
    }
}

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
public class Backpack {

    private int sum;
    private int[] source;
    private boolean[] mask;
    private int currentMaskSize;
    private int solutionsNumber;
    private int currentSum;

    public static void main(String[] args) {
        int n = 1;
        int s = 1;
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

    public void proceed() {
        upAndWork();
        while (isDown()) {
            if (isRight()) {
                right();
                upAndWork();
            } else {
                down();
            }
        }
        System.out.println("Total solutions: " + solutionsNumber);
    }

    private void upAndWork() {
        while(isUp()) {
            up();
        }
        work();
    }

    private void work() {
        if (currentSum == sum) {
            solutionsNumber++;
            printArrayByMask();
        }
    }

    private boolean isUp() {
        return (currentMaskSize < source.length) && (currentSum < sum);
    }

    private void up() {
        currentMaskSize++;
        currentSum += source[currentMaskSize-1];
        mask[currentMaskSize-1] = true;
    }

    private boolean isRight() {
        return mask[currentMaskSize-1];
    }

    private void right() {
        currentSum -= source[currentMaskSize-1];
        mask[currentMaskSize-1] = false;
    }

    private boolean isDown() {
        return currentMaskSize > 0;
    }

    private void down() {
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

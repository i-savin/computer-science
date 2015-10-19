package isavin.tasks.backtracking;

import isavin.tasks.combinatorics.Sequence;

public class Backpack {

    private int sum;
    private int[] source;
    private boolean[] mask;
    private int currentMaskSize;
    private int solutionsNumber;
    private int currentSum;

    public static void main(String[] args) {
        int n = 10;
        int s = 12;
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = i + 1;
        }

        Sequence.print(source);

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
        if (sumByMask() == sum) {
            solutionsNumber++;
            printArrayByMask();
        }
    }

    private boolean isUp() {
        // System.out.println((currentMaskSize < source.length) && (sumByMask() < sum));
        // if (currentMaskSize < 0) {
        //     return true;
        // }
        return (currentMaskSize < source.length - 1) && (sumByMask() < sum);
    }

    private void up() {
        currentMaskSize++;
        mask[currentMaskSize-1] = true;
        // sum += source[currentMaskSize];
    }

    private boolean isRight() {
        return mask[currentMaskSize-1];
    }

    private void right() {
        // sum -= source[currentMaskSize];
        mask[currentMaskSize-1] = false;
    }

    private boolean isDown() {
        return currentMaskSize > 0;
    }

    private void down() {
        if (mask[currentMaskSize-1]) {
            // sum -= source[currentMaskSize];
        }
        currentMaskSize--;
    }

    private int sumByMask() {
        int sum = 0;
        for (int i = 0; i < currentMaskSize; i++) {
            if (mask[i]) {
                sum += source[i];
            }
        }
        // System.out.println(sum);
        return sum;
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

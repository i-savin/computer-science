package isavin.tasks.backtracking;

import isavin.tasks.combinatorics.Sequence;

public class Doubles extends BacktrackingAbstract {
    private int n;
    private int[] source;
    private int currentSize;

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n: " + n);

        Doubles doubles = new Doubles(n);

        doubles.proceed();
    }

    public Doubles(int n) {
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
        if (currentSize <= 2 || (currentSize == n && !(source[currentSize - 1] == source[currentSize - 2]
            && source[currentSize - 2] == source[currentSize - 3]))) {
            Sequence.print(source);
            solutionsNumber++;
        }
    }

    @Override
    protected boolean isUp() {
        // System.out.println(currentSize);
		if (n < 3) {
			return currentSize < n;
		} else {
			return (currentSize <= 2 || (currentSize < n && !(source[currentSize - 1] == source[currentSize - 2]
                && source[currentSize - 2] == source[currentSize - 3])));
		}
    }

    @Override
    protected boolean isRight() {
        return source[currentSize - 1] == 0;
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

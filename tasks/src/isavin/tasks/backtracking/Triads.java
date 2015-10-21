package isavin.tasks.backtracking;

import isavin.tasks.combinatorics.Sequence;

public class Triads extends BacktrackingAbstract {
	
	private int n;
	private int[] source;
	private int currentSize;
	
	public static void main(String[] args) {
		int n = 3;
        System.out.println("n: " + n);

        Triads triads = new Triads(n);

        triads.proceed();
	}
	
	public Triads(int n) {
		this.n = n;
		this.source = new int[n];
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
		if (currentSize == 1 || currentSize == n && source[currentSize - 1] != source[currentSize - 2]) {
			Sequence.print(source);
			solutionsNumber++;
		}	
	}
	
	@Override
	protected boolean isUp() {
		return (currentSize <= 1) || (currentSize < n && source[currentSize - 1] != source[currentSize - 2]);
	}
	
	@Override
	protected boolean isRight() {
		return source[currentSize - 1] != 2;
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
		currentSize--;
	}
	
	@Override
	protected void right() {
		source[currentSize - 1]++;
	}
}

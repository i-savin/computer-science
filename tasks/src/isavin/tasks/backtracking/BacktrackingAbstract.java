package isavin.tasks.backtracking;

public abstract class BacktrackingAbstract {
	
	protected int solutionsNumber;
	
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
	
	protected abstract void upAndWork();
	
	protected abstract void work();
	
	protected abstract boolean isUp();
	
	protected abstract boolean isRight();
	
	protected abstract boolean isDown();
	
	protected abstract void up();
	
	protected abstract void down();
	
	protected abstract void right();

}

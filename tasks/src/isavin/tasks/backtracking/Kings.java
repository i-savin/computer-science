package isavin.tasks.backtracking;

public class Kings {
    //размер доски
    private int size;
    //количество выставленных ферзей
    private int kings = 0;
    //расположение ферзей - pozition[i] - позиция ферзя на i-й горизонтали
    private int[] pozition;
    private int solutionsNumber = 0;

    public static void main(String[] args) {
        Kings kings = new Kings(20);
        kings.proceed();
    }

    public Kings(int size) {
        this.size = size;
        this.pozition = new int[size];
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
        if (kings == size && !isDanger()) {
//            for (int i = 0; i < size; i++) {
//                System.out.print("<" + i + "," + pozition[i] + "> ");
//            }
//            System.out.println();
            solutionsNumber++;
        }
    }

    private boolean isDanger() {
        if (kings <= 1) {
            return false;
        }
        for (int i = 1; i < kings; i++) {
            if (pozition[i-1] == pozition[kings-1]
                || Math.abs(pozition[i-1] - pozition[kings-1]) == Math.abs(i - kings)) {
                    return true;
                }
        }
        return false;
    }

    private boolean isUp() {
        // System.out.print("isUp");
        return kings < size && !(isDanger());
    }

    private boolean isRight() {
        // System.out.print("isRight");
        return kings > 0 && pozition[kings-1] < size-1;
    }

    private boolean isDown() {
        // System.out.print("isDown");
        return kings > 0;
    }

    private void up() {
        // System.out.print("Up");
        kings++;
        pozition[kings-1] = 0;
    }

    private void down() {
        // System.out.print("Down");
        kings--;
    }

    private void right() {
        // System.out.print("right");
        pozition[kings-1]++;
    }

}

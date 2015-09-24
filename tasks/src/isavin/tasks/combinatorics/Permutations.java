package isavin.tasks.combinatorics;

import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        // List<Integer> l = Arrays.asList(1,2,3);
        List<Character> l = Arrays.asList('A', 'B', 'C', 'D');
        // swap(l, 0, 2);
        System.out.println(l);
        while (next(l)) {
            System.out.println(l);
        }
    }

    private static <T extends Comparable<T>> boolean next(List<T> current) {
        int index = current.size() - 2;
        while (index >= 0
            && current.get(index).compareTo(current.get(index+1)) > 0) {
            // System.out.println("Index: " + index + " " + current.get(index).compareTo(current.get(index+1)));
            index--;
        }
        if (index < 0) {
            return false;
        }
        int swapIndex = index + 1;
        while (swapIndex < current.size() - 1
                && current.get(swapIndex+1).compareTo(current.get(index)) > 0) {
            swapIndex++;
        }
        // System.out.println("swapIndex: " + swapIndex);
        swap(current, index, swapIndex);
        // System.out.println("some swap: " + current);
        for (int i = 0; i < (current.size() - index) / 2; i++) {
            swap(current, i + index + 1, current.size() - i - 1);
        }
        return true;
    }

    private static <T extends Comparable<T>> void swap(List<T> list, int from, int to) {
        T temp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, temp);
    }

}

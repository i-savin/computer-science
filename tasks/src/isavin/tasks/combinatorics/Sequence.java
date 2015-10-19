package isavin.tasks.combinatorics;

public class Sequence {

	public static void main(String[] args) {
		sequence2(4);
	}

	/**
	 * ���������� ��� ������������������ ����� �� 0 �� n ����� k
	 */
	public static void sequence(int k, int n) {
		int sequencesNumber = (int) Math.pow(n + 1, k) - 1;
		System.out.println(sequencesNumber);
		int i = 0;
		int[] a = new int[k];
		print(a);
		while (i < sequencesNumber) {
			a = next(a, n);
			print(a);
			i++;
		}
	}

	/**
	 * ���������� ��� ������������ ��������� 1..k
	 */
	public static void subset(int k) {
		int sequencesNumber = (int) Math.pow(2, k);
		int i = 0;
		int[] a = new int[k];
		for (int j = 0; j < a.length; j++) {
			a[j] = 1;
		}
		while (i < sequencesNumber) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] != 0) {
					System.out.print(j + 1 + " ");
				}
			}
			System.out.println();
			a = next2(a, 1);
			i++;
		}

		while (i < sequencesNumber) {

		}
	}

	/**
	 * ���������� ��� ������������������ ����� ����� k ����� ��� a[i]<=i
	 */
	public static void sequence2(int k) {
		int[] a = new int[k];
		int[] last = new int[k];
		for (int i = 0; i < last.length; i++) {
			last[i] = i;
		}

		while (!arraysEuqal(a, last)) {
			print(a);
			a = next3(a);
		}
		print(a);
	}

	/**
	 * ���������� ��������� ������� ������������������ ������������������ �������� (������ �������):
	 * 000, 001, 010, 011, 100, 101, 110, 111
	 */
	static int[] next(int[] a, int n) {
		int i = a.length - 1;
		while (i >= 0 && a[i] == n) {
			a[i] = 0;
			i--;
		}
		if (i >= 0) {
			a[i]++;
		}
		return a;
	}

	/**
	 * ���������� ��������� ������� ������������������ ������������������ �������� (�������� �������):
	 * 111, 110, 101, 100, 011, 010, 001,  000
	 */
	static int[] next2(int[] a, int n) {
		int i = a.length - 1;
		while (i >= 0 && a[i] == 0) {
			a[i] = n;
			i--;
		}
		if (i >= 0) {
			a[i]--;
		}
		return a;
	}

	static int[] next3(int[] a) {
		int i = a.length - 1;
		while (i >= 0 && a[i] == i) {
			a[i] = 0;
			i--;
		}
		if (i >= 0 && a[i] < i) {
			a[i]++;
		}
		return a;
	}

	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static boolean arraysEuqal(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
}

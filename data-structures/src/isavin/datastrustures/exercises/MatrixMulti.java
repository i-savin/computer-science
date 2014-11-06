package isavin.datastrustures.exercises;

public class MatrixMulti {

	private static final int MATRIX_SIZE = 3000;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		multiplyMatrix(generateMatrix(MATRIX_SIZE), generateMatrix(MATRIX_SIZE));
		multiplyMatrixMultithread(generateMatrix(MATRIX_SIZE), generateMatrix(MATRIX_SIZE));
		long endTime = System.currentTimeMillis();
		System.out.println("It takes " + (endTime - startTime) + " msecs");
	}
	
	private static long[][] generateMatrix(int size) {
		long[][] matrix = new long[size][size];
		int index = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = index++; 
			}
		}
		return matrix;
	}
	
	private static void printMatrix(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " "); 
			}
			System.out.println();
		}		
	}
	
	private static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
		long[][] result = new long[matrix1.length][matrix2.length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				for (int k = 0; k < matrix1.length; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];	
				}
			}
		}
		return result;
	}
	
	private static long[][] multiplyMatrixMultithread(final long[][] matrix1,
			final long[][] matrix2) {
		final long[][] result = new long[matrix1.length][matrix2.length];
		for (int i = 0; i < matrix1.length; i++) {
			final int iIndex = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < matrix2.length; j++) {
						for (int k = 0; k < matrix1.length; k++) {
							result[iIndex][j] += matrix1[iIndex][k]
									* matrix2[k][j];
						}
					}
				}

			}).start();

		}
		return result;
	}
}

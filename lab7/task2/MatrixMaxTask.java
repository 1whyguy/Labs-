package lab7.task2;

public class MatrixMaxTask {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 5, 13},
                {8, 22, 9},
                {4, 7, 16}
        };

        int[] maxInRows = new int[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                int max = matrix[row][0];
                for (int j = 1; j < matrix[row].length; j++) {
                    if (matrix[row][j] > max) {
                        max = matrix[row][j];
                    }
                }
                maxInRows[row] = max;
            });
            threads[i].start();
        }

        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            threads[i].join();
            if (maxInRows[i] > globalMax) {
                globalMax = maxInRows[i];
            }
        }

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}
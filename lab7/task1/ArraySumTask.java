package lab7.task1;

public class ArraySumTask {
    static int sum1 = 0;
    static int sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr.length / 2; i++) {
                sum1 += arr[i];
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = arr.length / 2; i < arr.length; i++) {
                sum2 += arr[i];
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int totalSum = sum1 + sum2;
        System.out.println("Общая сумма элементов массива: " + totalSum);
    }
}
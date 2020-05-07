package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExample {
    public static void main(String[] args) {
        int n = 1000;
        int [][] A = generateMatrix(n);
        int [][] B = generateMatrix(n);

        long time = System.currentTimeMillis();
        int [][] result = multiplyMatrix(A, B);
        long resultFirst = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        int [][] result1 = multiplyParaller(A, B);
        long resultSecond = System.currentTimeMillis() - time;
        System.out.println("Cons: " + resultFirst);
        System.out.println("Cons: " + resultSecond);
        System.out.println("Speed up: " + (double)resultSecond / resultFirst);
    }

    private static int [][] multiplyMatrix(int [][] a, int [][] b) {
        int n = a.length;
        int [][] result = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                for (int i = 0; i < n; i++) {
                    result[row][column] += a[row][i] * b[i][column];
                }
            }
        }
        return result;
    }

    public static int [][] multiplyParaller(int [][] a, int [][] b) {
        int n = a.length;
        int [][] result = new int[n][n];
        List<MultiplyTask> tasks = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                tasks.add(new MultiplyTask(a, b, result, row, column));
            }
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(32, 32, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        for(MultiplyTask task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    static class MultiplyTask implements Runnable {
        int [][] a;
        int [][] b;
        int [][] c;
        int row;
        int column;

        public MultiplyTask(int[][] a, int[][] b, int[][] c, int row, int column) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.row = row;
            this.column = column;
        }

        @Override
        public void run() {
            for (int i = 0; i < a.length; i++) {
                c[row][column] += a[row][i] * b[i][column];
            }
        }
    }

    private static int [][] generateMatrix(int n) {
        Random r = new Random();
        int [][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = r.nextInt();
            }
        }
        return result;
    }


}

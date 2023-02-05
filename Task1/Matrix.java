/**********************************************
Workshop 9
Course: JAC 444 - Summer 2022
Last Name: Himanshu
First Name: Himanshu
ID: 146109202
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature  Himanshu
Date: 08/07/2022
**********************************************/


import java.util.concurrent.TimeUnit;

public class Matrix {

    static double[][] matrixC = new double[2000][2000];

    public static void main(String[] args) {
        int size = 2000;

        double[][] matrix_1 = new double[size][size];
        double[][] matrix_2 = new double[size][size];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix_1[i][j] = Math.random() * 20;
                matrix_2[i][j] = Math.random() * 20;
            }
        }

        //Parallel
        Thread thread = new Thread(() -> {
            long start = System.nanoTime();
            matrixC = parallelAddMatrix(matrix_1, matrix_2, size);
            long elapsedTime = System.nanoTime() - start;
            TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            System.out.println("Parallel addition runtime: " + (elapsedTime / 1e9) * 1000.0 + " milliseconds.");
        });
        thread.start();
        //Sequential
        long start = System.nanoTime();
        parallelAddMatrix(matrix_1, matrix_2, size);
        long elapsedTime = System.nanoTime() - start;

        System.out.println("Sequential addition runtime: " + (elapsedTime / 1e9) * 1000.0 + " milliseconds.");
    }

    public static double[][] parallelAddMatrix(double[][] a, double[][] b, int size) {
        double[][] newMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMatrix[i][j] = a[i][j] + b[i][j];
            }
        }

        return newMatrix;
    }
}
package org.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;  // Максимальний розмір матриці
    private static final int MIN_RANDOM = -50; // Мінімальне значення для рандому
    private static final int MAX_RANDOM = 50;  // Максимальне значення для рандому

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Отримуємо розміри матриці
        System.out.print("Введіть кількість рядків (не більше " + MAX_SIZE + "): ");
        int rows = getValidSize(scanner);
        System.out.print("Введіть кількість стовпців (не більше " + MAX_SIZE + "): ");
        int cols = getValidSize(scanner);

        // Вибір способу заповнення матриці
        System.out.print("Виберіть спосіб заповнення (1 - вручну, 2 - випадкові числа): ");
        int choice = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else {
            fillMatrixRandomly(matrix);
        }

        // Вивід матриці
        printMatrix(matrix);

        // Обчислення та вивід результатів
        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.printf("Середнє арифметичне: %.2f\n", average);
        System.out.printf("Середнє геометричне: %.2f\n", geometricMean);

        scanner.close();
    }

    // Метод для отримання коректного розміру матриці
    private static int getValidSize(Scanner scanner) {
        int size;
        do {
            size = scanner.nextInt();
            if (size < 1 || size > MAX_SIZE) {
                System.out.print("Невірне значення. Введіть число від 1 до " + MAX_SIZE + ": ");
            }
        } while (size < 1 || size > MAX_SIZE);
        return size;
    }

    // Метод для заповнення матриці вручну
    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Метод для заповнення матриці випадковими числами
    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    // Метод для виводу матриці
    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    // Метод для знаходження мінімального значення в матриці
    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    // Метод для знаходження максимального значення в матриці
    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    // Метод для обчислення середнього арифметичного
    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }

    // Метод для обчислення середнього геометричного
    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) return 0;  // Якщо є 0, середнє геометричне стає 0
                product *= Math.abs(num); // Беремо модуль, щоб уникнути від'ємних коренів
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}

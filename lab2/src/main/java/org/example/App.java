package org.example;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Константи для обмеження розмірів та діапазону випадкових чисел
    public static final int MAX_ROWS = 20;
    public static final int MAX_COLS = 20;
    public static final int RAND_MIN = -50;
    public static final int RAND_MAX = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println("1 - Ручне введення");
        System.out.println("2 - Рандомна генерація");
        int mode = scanner.nextInt();

        // Введення кількості рядків та стовпців з обмеженням до 20
        System.out.print("Введіть кількість рядків (не більше 20): ");
        int rows = Math.min(scanner.nextInt(), MAX_ROWS);

        System.out.print("Введіть кількість стовпців (не більше 20): ");
        int cols = Math.min(scanner.nextInt(), MAX_COLS);

        // Ініціалізація матриці відповідно до вибраного режиму
        int[][] matrix = (mode == 1)
                ? createMatrixManual(scanner, rows, cols)
                : createMatrixRandom(rows, cols);

        printMatrix(matrix);

        // Обрахунок основних характеристик матриці
        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        // Виведення результатів
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.printf("Середнє арифметичне: %.2f\n", average);
        System.out.printf("Середнє геометричне: %.2f\n", geometricMean);
    }

    // Створення матриці з ручним введенням
    static int[][] createMatrixManual(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Генерація матриці випадковими числами
    static int[][] createMatrixRandom(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(RAND_MAX - RAND_MIN + 1) + RAND_MIN;
            }
        }
        return matrix;
    }

    // Виведення матриці в консоль
    static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }

    // Пошук мінімального значення у матриці
    static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix)
            for (int val : row)
                if (val < min) min = val;
        return min;
    }

    // Пошук максимального значення у матриці
    static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix)
            for (int val : row)
                if (val > max) max = val;
        return max;
    }

    // Розрахунок середнього арифметичного значення
    static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix)
            for (int val : row) {
                sum += val;
                count++;
            }
        return (double) sum / count;
    }

    // Розрахунок середнього геометричного (з використанням абсолютних значень)
    static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix)
            for (int val : row) {
                // Додаємо маленьку константу, щоб уникнути множення на 0
                product *= Math.abs(val) + 1e-10;
                count++;
            }
        return Math.pow(product, 1.0 / count);
    }
}

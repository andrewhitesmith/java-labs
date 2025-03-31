package org.example;

import org.example.controller.StudentRepository;
import org.example.model.Student;

import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();

        System.out.println("== Всі студенти ==");
        repo.getAllStudents().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть номер місяця (1-12), щоб вивести студентів, народжених у цьому місяці: ");

        int month;
        while (true) {
            try {
                month = Integer.parseInt(scanner.nextLine());
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.print("Будь ласка, введіть число від 1 до 12: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Некоректне значення. Спробуйте ще раз: ");
            }
        }

        List<Student> studentsByMonth = repo.getStudentsByBirthMonth(month);

        if (studentsByMonth.isEmpty()) {
            System.out.println("\nСтудентів, народжених у " + getMonthName(month) + ", не знайдено.");
        } else {
            System.out.println("\n== Студенти, народжені в " + getMonthName(month) + " ==");
            studentsByMonth.forEach(System.out::println);
        }

        scanner.close();
    }

    private static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "січні";
            case 2 -> "лютому";
            case 3 -> "березні";
            case 4 -> "квітні";
            case 5 -> "травні";
            case 6 -> "червні";
            case 7 -> "липні";
            case 8 -> "серпні";
            case 9 -> "вересні";
            case 10 -> "жовтні";
            case 11 -> "листопаді";
            case 12 -> "грудні";
            default -> "невідомому місяці";
        };
    }
}

package CodeSoft;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        int totalMarks = 0;

        // Taking input for marks
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            // Ensure valid input
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // Decrement to re-enter marks for the same subject
                continue;
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Determine grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}


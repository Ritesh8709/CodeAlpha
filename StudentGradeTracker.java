import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grades for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            grades.add(grade);
        }

        double average = calculateAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double findLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
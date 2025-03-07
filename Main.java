import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Enter students' grades (enter -1 to finish):");

        // Input grades
        while (true) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();

            // Stop input if -1 is entered
            if (grade == -1) {
                break;
            }

            // Add grade to the list
            grades.add(grade);
        }

        // Check if grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Compute average, highest, and lowest grades
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                sum += grade;

                if (grade > highest) {
                    highest = grade;
                }

                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = sum / grades.size();

            // Display results
            System.out.println("\nResults:");
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }
}
    


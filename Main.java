import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Display Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    generateReport();
                    break;

                case 4:
                    System.out.println("Program Exited.");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addStudent(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(name, marks));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student Details ---");

        for (Student s : students) {

            System.out.println("Name: " + s.name +
                    " | Marks: " + s.marks);
        }
    }

    static void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student s : students) {

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                highestStudent = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.println("\n===== SUMMARY REPORT =====");

        System.out.println("Total Students : " + students.size());

        System.out.println("Average Marks  : " + average);

        System.out.println("Highest Marks  : " + highest +
                " (" + highestStudent + ")");

        System.out.println("Lowest Marks   : " + lowest +
                " (" + lowestStudent + ")");
    }
}
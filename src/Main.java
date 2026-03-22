import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Find student by code");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Student code: ");
                    String code = scanner.nextLine();
                    System.out.print("Full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Class name: ");
                    String className = scanner.nextLine();
                    System.out.print("Subject name: ");
                    String subject = scanner.nextLine();
                    System.out.print("Score: ");
                    double score = Double.parseDouble(scanner.nextLine());

                    studentService.addStudent(new Student(code, name, className, subject, score));
                    break;

                case 2:
                    studentService.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student code: ");
                    studentService.findStudent(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("Student code to update: ");
                    String updateCode = scanner.nextLine();
                    System.out.print("New full name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("New class name: ");
                    String updateClass = scanner.nextLine();
                    System.out.print("New subject name: ");
                    String updateSubject = scanner.nextLine();
                    System.out.print("New score: ");
                    double updateScore = Double.parseDouble(scanner.nextLine());

                    studentService.updateStudent(
                            new Student(updateCode, updateName, updateClass, updateSubject, updateScore)
                    );
                    break;

                case 5:
                    System.out.print("Student code to delete: ");
                    studentService.deleteStudent(scanner.nextLine());
                    break;

                case 0:
                    System.out.println("Exit.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

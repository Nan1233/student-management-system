package service;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) {
        if (student.getScore() < 0 || student.getScore() > 10) {
            System.out.println("Score must be between 0 and 10.");
            return;
        }
        studentDAO.addStudent(student);
    }

    public void showAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    public void findStudent(String studentCode) {
        Student student = studentDAO.findByStudentCode(studentCode);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    public void updateStudent(Student student) {
        if (student.getScore() < 0 || student.getScore() > 10) {
            System.out.println("Score must be between 0 and 10.");
            return;
        }
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(String studentCode) {
        studentDAO.deleteStudent(studentCode);
    }
}

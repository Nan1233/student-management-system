package dao;

import db.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students(student_code, full_name, class_name, subject_name, score) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getStudentCode());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getClassName());
            ps.setString(4, student.getSubjectName());
            ps.setDouble(5, student.getScore());

            ps.executeUpdate();
            System.out.println("Added student successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("student_code"),
                        rs.getString("full_name"),
                        rs.getString("class_name"),
                        rs.getString("subject_name"),
                        rs.getDouble("score")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error getting students: " + e.getMessage());
        }

        return students;
    }

    public Student findByStudentCode(String studentCode) {
        String sql = "SELECT * FROM students WHERE student_code = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentCode);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("student_code"),
                        rs.getString("full_name"),
                        rs.getString("class_name"),
                        rs.getString("subject_name"),
                        rs.getDouble("score")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error finding student: " + e.getMessage());
        }
        return null;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET full_name=?, class_name=?, subject_name=?, score=? WHERE student_code=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getFullName());
            ps.setString(2, student.getClassName());
            ps.setString(3, student.getSubjectName());
            ps.setDouble(4, student.getScore());
            ps.setString(5, student.getStudentCode());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Updated student successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(String studentCode) {
        String sql = "DELETE FROM students WHERE student_code=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentCode);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted student successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}

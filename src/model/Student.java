package model;

public class Student {
    private int id;
    private String studentCode;
    private String fullName;
    private String className;
    private String subjectName;
    private double score;

    public Student() {}

    public Student(String studentCode, String fullName, String className, String subjectName, double score) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.className = className;
        this.subjectName = subjectName;
        this.score = score;
    }

    public Student(int id, String studentCode, String fullName, String className, String subjectName, double score) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.className = className;
        this.subjectName = subjectName;
        this.score = score;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStudentCode() { return studentCode; }
    public void setStudentCode(String studentCode) { this.studentCode = studentCode; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentCode='" + studentCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", className='" + className + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", score=" + score +
                '}';
    }
}

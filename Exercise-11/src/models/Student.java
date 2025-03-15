package models;

public class Student {
    private final String name;
    private final int marks;
    private final String grade;

    public Student(final String name, final int marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    private String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return name + " - Marks: " + marks + " - Grade: " + grade;
    }
}
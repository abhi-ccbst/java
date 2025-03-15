package services;

import models.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    // Get students who scored above a certain threshold
    public List<Student> getTopStudents(final int minMarks) {
        return students.stream()
                .filter(s -> s.getMarks() >= minMarks)
                .sorted((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks())) // Descending order
                .collect(Collectors.toList());
    }

    public List<Student> getBottomStudents(final int maxMarks) {
        return students.stream()
                .filter(s -> s.getMarks() <= maxMarks)
                .sorted((s1, s2) -> Integer.compare(s1.getMarks(), s2.getMarks())) // Descending order
                .collect(Collectors.toList());
    }


    public void printAllStudents() {
        students.forEach(System.out::println);
    }
}

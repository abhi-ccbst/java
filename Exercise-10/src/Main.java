import student.GradeCalculator;
import student.GradeUtils;
import student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 95),
                new Student("Bob", 70),
                new Student("Charlie", 88),
                new Student("David", 60),
                new Student("Eva", 78)
        );

        GradeCalculator gradeCalculator = GradeUtils::getGrade;
        //Filter
        Predicate<Student> highScorer = s -> s.marks() >= 75;
        List<Student> topStudents = students.stream().filter(highScorer).sorted((s1, s2) ->
            Integer.compare(s2.marks(),s1.marks())
        ).toList();
        System.out.println("🎓 Top Students:");
        topStudents.forEach(s ->
                System.out.println(s.name() + " - Marks: " + s.marks() + " - Grade: " + gradeCalculator.calculate(s.marks()))
        );
    }
}
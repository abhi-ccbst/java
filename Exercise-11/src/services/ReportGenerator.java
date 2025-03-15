package services;

import models.Student;

import java.util.List;

public class ReportGenerator extends Thread {
    private final List<Student> students;
    private final String reportName;

    public ReportGenerator(List<Student> students, String reportName) {
        this.students = students;
        this.reportName = reportName;
    }

    @Override
    public void run() {
        System.out.println("\n🔹 Generating Report: " + reportName);
        students.forEach(s -> System.out.println(Thread.currentThread().getName() + " → " + s));
        System.out.println("✅ Report " + reportName + " Completed!\n");
    }
}

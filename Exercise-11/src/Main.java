import models.Student;
import myAnnotation.AnnotationProcessor;
import myAnnotation.MyAnnotation;
import myAnnotation.TaskProcessor;
import myAnnotation.Version;
import services.MyService;
import services.MyServiceImpl;
import services.ReportGenerator;
import services.StudentService;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Version(number = 1,author = "Abhi Patel")
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        TaskProcessor taskProcessor = new TaskProcessor();
        taskProcessor.submitTasks();
        taskProcessor.submitTasks();
        taskProcessor.shutdown();

//
//        MyService myService = new MyServiceImpl();
//        AnnotationProcessor.invokeWithLogging(myService);
//        myService.fastMethod();
//        myService.slowMethod();
//
//        Main.testAnnotation();
//        Method method = Main.class.getMethod("testAnnotation");
//        if (method.isAnnotationPresent(MyAnnotation.class)) {
//            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//            System.out.println("Annotation Value: " + annotation.k());
//        }
//
//
//        List<Student> students = Arrays.asList(
//                new Student("Alice", 95),
//                new Student("Bob", 70),
//                new Student("Charlie", 88),
//                new Student("David", 60),
//                new Student("Eva", 78),
//                new Student("Frank", 85)
//        );
//
//        StudentService service = new StudentService(students);
//        System.out.println("📌 All Students:");
//        service.printAllStudents();
//
//        List<Student> topStudents = service.getTopStudents(75);
//        System.out.println("\n🏆 Top Students (Marks > 75):");
//        topStudents.forEach(System.out::println);
//
//
//        List<Student> lastStudents = service.getBottomStudents(75);
//        System.out.println("\n🏆 Bottom Students (Marks < 75):");
//        topStudents.forEach(System.out::println);
//
//
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ReportGenerator report1 = new ReportGenerator(students, "All Students Report");
//        ReportGenerator report2 = new ReportGenerator(topStudents, "Top Students Report");
//        ReportGenerator report3 = new ReportGenerator(topStudents, "Bottom Students Report");
//
//
//        executorService.execute(report1);
//        executorService.execute(report2);
//        executorService.execute(report3);
//
//        executorService.shutdown();
//
//        try{
//            if(executorService.awaitTermination(50, TimeUnit.SECONDS)) {
//                System.out.println("All tasks completed successfully.");
//            } else {
//                System.out.println("Timeout reached! Some tasks are still running.");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//
//        System.out.println("🏁 All reports generated successfully!");

    }

    @MyAnnotation(value = "Hello, Students!", k = 3)
    public static void testAnnotation() {
        System.out.println("Executing show() method");
    }
}
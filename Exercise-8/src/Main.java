import employee.EmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Task 1: " + employeeService.task1());
        System.out.println("Task 2: " + employeeService.task2());
        System.out.println("Task 3: " + employeeService.task3());
        System.out.println("Task 4: " + employeeService.task4());
        System.out.println("Task 5: " + employeeService.task5());
        System.out.println("Task 6: " + employeeService.task6());
    }
}
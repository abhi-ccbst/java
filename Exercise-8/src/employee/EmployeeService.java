package employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> employees = List.of(
            new Employee(1, "Alice", "IT", 75000, 28, 6),
            new Employee(2, "Bob", "HR", 55000, 32, 4),
            new Employee(3, "Charlie", "Finance", 60000, 40, 10),
            new Employee(4, "David", "IT", 80000, 35, 8),
            new Employee(5, "Eve", "Finance", 90000, 45, 15),
            new Employee(6, "Frank", "IT", 95000, 30, 7),
            new Employee(7, "Grace", "HR", 58000, 29, 3)
    );

    // ✅ Task 1: Employees with more than 5 years of experience
    public List<Employee> task1() {
        return employees.stream().filter(e -> e.getExperience() > 5).collect(Collectors.toList());
    }

    // ✅ Task 2: Employee with the highest salary
    public Employee task2() {
        return employees.stream().max(Comparator.comparing(e -> e.getSalary())).get();
    }

    // ✅ Task 3: Average salary per department
    public Map<String, Double> task3() {
        return employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(f -> f.getSalary())));
    }

    // ✅ Task 4: Count employees in each department
    public Map<String, Long> task4() {
        return employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
    }

    // ✅ Task 5: Employees sorted by age
    public List<String> task5() {
        return employees.stream().sorted(Comparator.comparing(e -> e.getAge()))
                .map(e -> e.getName())
                .collect(Collectors.toList());
    }

    // ✅ Task 6: Top 3 highest-paid employees
    public List<String> task6() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .map(e->e.getName()).collect(Collectors.toList());
    }
}



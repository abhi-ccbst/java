package employee;

public class Employee {
    private final  int id;
    private final String name;
    private final String department;
    private final double salary;
    private final int age;
    private final int experience;

    public Employee(int id, String name, String department, double salary, int age, int experience) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }
}

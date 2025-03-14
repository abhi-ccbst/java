package student;

public record Student(String name, int marks) {

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}


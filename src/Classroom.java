import java.util.*;

public class Classroom {
    private String className;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}

import java.util.*;

class Student {
    private String studentId;
    private String className;
    private List<Assignment> submittedAssignments;

    public Student(String studentId, String className) {
        this.studentId = studentId;
        this.className = className;
        this.submittedAssignments = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }

    public List<Assignment> getSubmittedAssignments() {
        return submittedAssignments;
    }

    public void addSubmittedAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }
}
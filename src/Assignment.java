import java.util.*;

public class Assignment {
    private String assignmentDetails;
    private String className;

    public Assignment(String assignmentDetails, String className) {
        this.assignmentDetails = assignmentDetails;
        this.className = className;
    }

    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public String getClassName() {
        return className;
    }
}
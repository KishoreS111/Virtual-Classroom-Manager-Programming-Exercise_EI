import java.util.*;

public class VirtualClassroomManager {
    private List<Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new ArrayList<>();
    }

    public void addClassroom(String className) {
        Classroom classroom = new Classroom(className);
        classrooms.add(classroom);
        System.out.println("Classroom Addition: \"Classroom " + className + " has been created.\"");
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = getClassroomByName(className);
        try {
        	if (classroom != null) {
            	try {
            		if (!isStudentEnrolled(classroom, studentId)) {
                        Student student = new Student(studentId, className);
                        classroom.addStudent(student);
                        System.out.println("Student Addition: \"Student " + studentId + " has been enrolled in " + className + ".\"");
                    } else {
                    	throw new ErrorHandler("Error: Student " + studentId + " is already enrolled in Classroom " + className + ".");
                        //System.out.println("Error: Student " + studentId + " is already enrolled in Classroom " + className + ".");
                    }
            	}catch(ErrorHandler e)
            	{
            		
            	}
            } else {
            	throw new ErrorHandler("Error: Classroom " + className + " not found.");
            }
        }catch(ErrorHandler e) {
        	
        }
    }

    private boolean isStudentEnrolled(Classroom classroom, String studentId) {
        for (Student student : classroom.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = getClassroomByName(className);
        try
        {
        	if (classroom != null) {
                Assignment assignment = new Assignment(assignmentDetails, className);
                classroom.scheduleAssignment(assignment);
                System.out.println("Assignment Scheduled: \"Assignment for " + className + " has been scheduled.\"");
            } else {
            	throw new ErrorHandler("Error: Classroom " + className + " not found.");
                //System.out.println("Error: Classroom " + className + " not found.");
            }
        }catch(ErrorHandler e)
        {
        	
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) throws ErrorHandler{
        Classroom classroom = getClassroomByName(className);
        try 
        {
        	if (classroom != null) {
                Assignment assignment = getAssignmentByName(classroom, assignmentDetails);
                if (assignment != null) {
                    boolean studentFound = false;
                    for (Student student : classroom.getStudents()) {
                        if (student.getStudentId().equals(studentId)) {
                            studentFound = true;
                            if (!hasStudentSubmittedAssignment(student, assignment)) {
                                // Additional logic for assignment submission (if needed)
                                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                                student.addSubmittedAssignment(assignment);
                            } else {
                            	throw new ErrorHandler("Error: Student " + studentId + " has already submitted this assignment.");
                                //System.out.println("Error: Student " + studentId + " has already submitted this assignment.");
                            }
                            break; 
                        }
                    }

                    if (!studentFound) {
                    	throw new ErrorHandler("Error: Student " + studentId + " not found in Classroom " + className + ".");
                        //System.out.println("Error: Student " + studentId + " not found in Classroom " + className + ".");
                    }
                } else {
                	throw new ErrorHandler("Error: Assignment " + assignmentDetails + " not found in Classroom " + className + ".");
                    //System.out.println("Error: Assignment " + assignmentDetails + " not found in Classroom " + className + ".");
                }
            } else {
            	throw new ErrorHandler("Error: Classroom " + className + " not found.");
                //System.out.println("Error: Classroom " + className + " not found.");
            }
        }catch(ErrorHandler e)
        {
        	
        }
    }

    private Assignment getAssignmentByName(Classroom classroom, String assignmentDetails) {
        for (Assignment assignment : classroom.getAssignments()) {
            if (assignment.getAssignmentDetails().equals(assignmentDetails)) {
                return assignment;
            }
        }
        return null;
    }

    private boolean hasStudentSubmittedAssignment(Student student, Assignment assignment) {
        return student.getSubmittedAssignments().contains(assignment);
    }

    public void displayClassrooms() {
        System.out.println("Number of Classrooms: " + getNumberOfClassrooms());
        for (Classroom classroom : classrooms) {
            System.out.println("Classroom: " + classroom.getClassName());
            System.out.println("Number of Students: " + getNumberOfStudents(classroom.getClassName()));
            System.out.println("Number of Assignments: " + getNumberOfAssignments(classroom.getClassName()));
            System.out.println();
        }
    }

    public int getNumberOfClassrooms() {
        return classrooms.size();
    }

    public int getNumberOfStudents(String className) {
        Classroom classroom = getClassroomByName(className);
        return (classroom != null) ? classroom.getStudents().size() : 0;
    }

    public int getNumberOfAssignments(String className) {
        Classroom classroom = getClassroomByName(className);
        return (classroom != null) ? classroom.getAssignments().size() : 0;
    }

    private Classroom getClassroomByName(String className) {
        for (Classroom classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                return classroom;
            }
        }
        return null;
    }
}
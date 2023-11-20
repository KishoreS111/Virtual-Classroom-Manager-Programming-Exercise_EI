import java.util.*;

public class Main {
    public static void main(String[] args) throws ErrorHandler {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("User Input:");
            System.out.println("1. Add Classroom: User types add_classroom followed by the class name");
            System.out.println("2. Add Student: User types add_student followed by student ID and class name");
            System.out.println("3. Schedule Assignment: User types schedule_assignment followed by class name and assignment details");
            System.out.println("4. Submit Assignment: User types submit_assignment followed by student ID, class name, and assignment details");
            System.out.println("5. Display Classrooms");
            System.out.println("6. Exit");

            System.out.print("Enter your command: ");
            String userCommand = scanner.nextLine();
            String[] parts = userCommand.split(" ");

            try {
                switch (parts[0]) {
                    case "add_classroom":
                        String className = parts[1];
                        manager.addClassroom(className);
                        break;
                    case "add_student":
                        if (parts.length == 3) {
                            String studentId = parts[1];
                            String classToAddStudent = parts[2];
                            manager.addStudent(studentId, classToAddStudent);
                        } else {
                            throw new ErrorHandler("Error: Incorrect number of inputs. Please provide both student ID and class name.");
                        }
                        break;
                    case "schedule_assignment":
                        if (parts.length == 3) {
                            String classToScheduleAssignment = parts[1];
                            String assignmentDetails = parts[2];
                            manager.scheduleAssignment(classToScheduleAssignment, assignmentDetails);
                        } else {
                            throw new ErrorHandler("Error: Incorrect number of inputs. Please provide both class name and assignment details.");
                        }
                        break;
                    case "submit_assignment":
                        if (parts.length == 4) {
                            String studentIdSubmitAssignment = parts[1];
                            String classSubmitAssignment = parts[2];
                            String assignmentDetailsSubmitAssignment = parts[3];
                            manager.submitAssignment(studentIdSubmitAssignment, classSubmitAssignment, assignmentDetailsSubmitAssignment);
                        } else {
                            throw new ErrorHandler("Error: Incorrect number of inputs. Please provide student ID, class name, and assignment details.");
                        }
                        break;
                    case "display_classrooms":
                        manager.displayClassrooms();
                        break;
                    case "exit":
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } catch (ErrorHandler e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

import java.util.List;
import java.util.ArrayList;

public class Course {

    private static final int MAX_STUDENTS = 2;
    private List<String> students = new ArrayList<>();

    public static void main(String[] args) {
        Course course = new Course();
        List<String> students = new ArrayList<>();
        students.add("Donald Duck");
        students.add("Donald Duck");
        students.add("Uncle Scrooge");
        students.add("Gyro Gearloose");

        for (String student : students) {
            if (course.addStudent(student)) {
                System.out.println("Successfully added " + student);
            } else {
                System.out.println("Failed to add " + student);
            }
        }
    }

    private boolean addStudent(String student) {
        try {
            if (students.size() >= MAX_STUDENTS) {
                throw new CourseFullException();
            }
            if (students.contains(student)) {
                throw new StudentAlreadyEnrolledException();
            }
        } catch (CourseFullException ex) {
            System.out.println("This Course is full!");
            return false;
        } catch (StudentAlreadyEnrolledException ex) {
            System.out.println("This Student is already enrolled here!");
            return false;
        }
        students.add(student);
        return true;
    }

    // Inner exception classes for readability

    private static class CourseFullException extends Exception {
        private CourseFullException() {
        }
    }

    private static class StudentAlreadyEnrolledException extends Exception {
        private StudentAlreadyEnrolledException() {
        }
    }
}

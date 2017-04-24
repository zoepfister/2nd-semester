import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Course implements Lecture {

    // Start of Task 1

    int courseID;
    int maxStudents;
    Room room;
    List<Student> students = new ArrayList<>();
    boolean roomIsFull;
    Employee employee;
    boolean isProfessor;

    // SheetFour stuff

    public Course() {
        System.out.println("Course object created!");
    }

    public Course(int courseID, Room room) {
        this.courseID = courseID;
        this.room = room;
    }

    public Course(int courseID, Room room, Employee employee) {
        this.courseID = courseID;
        this.room = room;
        this.employee = employee;

        if (!(employee instanceof Professor)) {
            isProfessor = false;
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Student> getStudents() {
        return students;
    }


    // Constructors

    public void addStudent(Student student) {
        // Compare student amount with roomCapacity
        if (students.size() >= room.capacity) {
            roomIsFull = true;
            System.out.println("Room capacity has been reached.");
            // This would allow us to not be able to add any more students
            /// return
        } else {
            roomIsFull = false;
        }
        // Check if student is already in course
        if (students.contains(student)) {
            System.out.println("This student is already visiting this course!");
            return;
        }

        // Appends the specified element to the end of this list.
        this.students.add(student);

        // To beautify, added two print cases
        if ((student.firstname == null) || (student.lastname == null)) {
            System.out.println("Student with id " + student.studentId + " has been added.");
        } else {
            System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " has been added.");
        }
    }

    public void addTeacher(Employee employee) {
        if (employee instanceof Professor) {
            this.employee = employee;
        } else {
            this.employee = null;
        }
    }

    public void removeStudent(Student student) {
        // Check if list is empty
        if (students.size() > 0) {
            // Removes the first occurrence of the specified element from this list, if it is present.
            this.students.remove(student);
            System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " has been removed.");
        } else {
            System.out.println("Error! This list seems to be empty");
        }
    }

    public void printStudents() {
        if (students.size() > 0) {
            // this. is not necessary here
            for (Student student : students) {
                System.out.println(this.students.indexOf(student) + ": " + " - " + student.getStudentId() + " - " + student.getFirstname() + " " + student.getLastname());
            }
        } else {
            System.out.println("There are no students in this course!");
        }
    }


}

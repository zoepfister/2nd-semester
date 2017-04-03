import java.util.ArrayList;
import java.util.List;

/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Course {

    // Start of Task 1

    int courseId;
    int maxStudents;
    Room room;
    List<Student> students = new ArrayList<>();
    String courseName;
    Professor professor;
    boolean roomIsFull;

    // Constructors
    public Course(int courseId, Room room) {
        this.courseId = courseId;
        this.room = room;
    }

    public Course(int courseId, Room room, Professor professor) {
        this.courseId = courseId;
        this.room = room;
        this.professor = professor;
    }

    // Getter
    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    // End of Task 1
    // Start of Task 2

    // TODO: Allow multiple additions at once
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
        for (Student studentCount : students) {
            if (students.contains(student)) {
                System.out.println("This student is already visiting this course!");
                return;
            }
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

    // End of Task 2

    public Course() {
        System.out.println("Course object created successfully!");
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents < 1) {
            System.out.println("Please choose an integer value of at least 1.");
        } else {
            this.maxStudents = maxStudents;
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentAmount() {
        return this.students.size();
    }


    public void removeStudent(Student student) {
        // Check if list is empty
        if (getStudentAmount() > 0) {
            // Removes the first occurrence of the specified element from this list, if it is present.
            this.students.remove(student);
            System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " has been removed.");
        } else {
            System.out.println("Error! This list seems to be empty");
        }
    }

    public void printStudents() {
        if (getStudentAmount() > 0) {
            // this. is not necessary here
            for (Student student : students) {
                System.out.println(this.students.indexOf(student) + ": " + this.courseName + " - " + student.getStudentId() + " - " + student.getFirstname() + " " + student.getLastname());
            }
        } else {
            System.out.println("There are no students in this course!");
        }
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

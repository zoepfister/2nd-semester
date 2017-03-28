import java.util.ArrayList;
import java.util.List;

/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Course {

    int id;
    int maxStudents;
    // List object, doesn't say how it's implemented
    List<Student> students = new ArrayList<>();
    String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course() {
        System.out.println("Course object created successfully!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents < 1) {
            System.out.println("Please choose an integer value of at least 1.");
        } else {
            this.maxStudents = maxStudents;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentAmount() {
        return this.students.size();
    }

    // TODO: Allow multiple additions at once
    public void addStudent(Student student) {
        // Compare student amount with maxStudents
        if (getStudentAmount() >= this.maxStudents) {
            System.out.println("Error! This course is already full!");
        } else {
            for (Student studentCount : students) {
                int studentId = student.id;
                int indexOfStudent = this.students.indexOf(studentCount);
                if (studentId == this.students.get(indexOfStudent).id) {
                    System.out.println("This student is already visiting this course.");
                    // FIXME: exit method if student with equal id's are found (is this bad code?)
                    return;
                }
            }
            // Appends the specified element to the end of this list.
            this.students.add(student);
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " has been added.");
        }

    }

    public void removeStudent(Student student) {
        // Check if list is empty
        if (getStudentAmount() > 0) {
            // Removes the first occurrence of the specified element from this list, if it is present.
            this.students.remove(student);
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " has been removed.");
        } else {
            System.out.println("Error! This list seems to be empty");
        }
    }

    public void printStudents() {
        if (getStudentAmount() > 0) {
            // this. is not necessary here
            for (Student student : students) {
                System.out.println(this.students.indexOf(student) + ": " + this.courseName + " - " + student.getId() + " - " + student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("There are no students in this course!");
        }
    }


}

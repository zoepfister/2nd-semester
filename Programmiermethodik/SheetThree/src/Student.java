/**
 * Created by clemenspfister on 31/03/2017.
 */
public class Student {
    int studentId;
    String firstname;
    String lastname;

    public Student(int studentId, String firstname, String lastname) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Start of Task 2

    public boolean equals(Student student) {

        if (this == student) {
            return true;
        }

        if (student == null) {
            return false;
        }

        if (!(student instanceof Student)) {
            return false;
        }

        Student other = student;
        if (studentId != other.studentId) {
            return false;
        }

        return true;
    }

}
